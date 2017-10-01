package cn.bupt.sse508.versioncontrol.network;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import midfile.json.graphiti.ToMidFile;


public class HttpAgent {
	private static HttpAgent httpAgent = null;
	private HttpAgent() {
		
	}
	public static HttpAgent getInstance() {
		if (null == httpAgent) {
			httpAgent = new HttpAgent();
		}
		return httpAgent;
	}
	
	private HttpPost createHttpConnection() {
		return new HttpPost(NetworkUtils.SERVER_ADDRESS); // SERVER_ADDRESS = "http://172.16.1.111:8080"
	}

	/**
	 * 提供向服务器发送push请求的命令1，会自动调用命令2和命令3，使用者只需要提供参数，不需要关心命令的执行过程
	 * @param base 前置版本的hash值
	 * @param description 此次版本的描述
	 * @param fileCount 所需发送文件的数量
	 * @param fileList 文件的绝对路径名称列表
	 * @return
	 */
	public List<HttpResponceVO> generatePushReq(String base, String description, int fileCount, List<String> fileList) {
		CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        
        httpClient = HttpClients.createDefault();
        HttpPost httpPost = createHttpConnection(); // httpPost = "http://172.16.1.111:8080"
        
		StringBody command = new StringBody(NetworkUtils.PUSH, ContentType.create("text/plain", Consts.UTF_8));
		StringBody commit = new StringBody(generateHashValueByTime(), ContentType.create("text/plain", Consts.UTF_8));
		StringBody baseBody = new StringBody(base, ContentType.create("text/plain", Consts.UTF_8));
		StringBody descriptionBody = new StringBody(description, ContentType.create("text/plain", Consts.UTF_8));
		StringBody fileCountBody = new StringBody(fileCount+"", ContentType.create("text/plain", Consts.UTF_8));
		System.out.println("fileCountBody: " + fileCountBody);
		StringBody step = new StringBody(NetworkUtils.START, ContentType.create("text/plain", Consts.UTF_8));
		
		HttpEntity reqEntity = MultipartEntityBuilder.create()
				.addPart(NetworkUtils.COMMAND, command)
				.addPart(NetworkUtils.COMMIT, commit)
				.addPart(NetworkUtils.BASE, baseBody)
				.addPart(NetworkUtils.DESCRIPTION, descriptionBody)
				.addPart(NetworkUtils.FILE_COUNT, fileCountBody)
				.addPart(NetworkUtils.STEP, step)
				.build();
		httpPost.setEntity(reqEntity);
		
        try {
        	// 发起请求 并返回请求的响应
			response = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        int status = response.getStatusLine().getStatusCode();
        if (status == 200) { // 成功返回，可以发送文件了
        	for (int i = 0; i < fileList.size(); i++) {
				pushReq2(commit, fileList.get(i), i+1);
			}
		} else {

		}
        
        // 此处应该所有文件都发送成功了，此时应该等待服务器处理完成
        boolean isServerDoneProcess = false;
        String res = "";
        while (!isServerDoneProcess) {
        	res = pushReq3(command, commit);
        	if (res.startsWith("Processing")) {
        		try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        		isServerDoneProcess = false;
        	}
        	else
        		isServerDoneProcess = true;
        }
        
        // 将返回的结果分段
        String[] resArr = res.split(NetworkUtils.RESULT_SPLITER); 
        System.out.println("返回结果: "+res);
        String versionNum = resArr[1];
        System.out.println("versionNum: "+versionNum);
        
        List<HttpResponceVO> resultList = new ArrayList<HttpResponceVO>();
        // resultList中的第一个VO存储的是总体的状态;
        {
        	HttpResponceVO resultVO = new HttpResponceVO();
            resultVO.status = 200;
            resultVO.result = resArr[0];
            System.out.println("result: "+resArr[0]);
            resultVO.versionNo = versionNum;
            resultList.add(resultVO);
        }
        
        int f = 0;
        for (int i = 2; i < resArr.length && f < fileList.size(); i+=3, f++) {
        	HttpResponceVO resultVO = new HttpResponceVO();
            resultVO.status = 200;
            resultVO.versionNo = versionNum;
            resultVO.fileName = fileList.get(f);
            // 此处服务器应该处理完成，结果储存在res中
            // 处理冲突描述文件
            {
            	JSONArray conflictsArr = new JSONObject(resArr[i]).getJSONArray("conflict_node");
            	if (conflictsArr.length() > 0) { // 有冲突
            		resultVO.result = "Refuse";
            		resultVO.conflictList = new ArrayList<>();
            		for (int j = 0; j < conflictsArr.length(); j++) {
						resultVO.conflictList.add(conflictsArr.getJSONObject(j));
					}
				} else { // 无冲突
					resultVO.result = "OK";
					resultVO.conflictList = new ArrayList<>();
				}
            }
            // 处理合并列表
            {
            	JSONArray mergedNaviArr = new JSONObject(resArr[i+1]).getJSONArray("merged_navi");
            	resultVO.mergeList = new ArrayList<>();
            	for (int j = 0; j < mergedNaviArr.length(); j++) {
            		resultVO.mergeList.add(mergedNaviArr.getJSONObject(j));
				}
            	JSONArray mergedNodeArr = new JSONObject(resArr[i+1]).getJSONArray("merged_node");
            	for (int j = 0; j < mergedNodeArr.length(); j++) {
            		resultVO.mergeList.add(mergedNodeArr.getJSONObject(j));
				}
            }
            // 处理返回的图表
            {
            	resultVO.fileContent = resArr[i+2];
            }

            resultList.add(resultVO);
		}
        System.out.println("resultList:" + resultList);
		return resultList;
	}
	
	/**
	 * 提供向服务器发送pull请求的命令
	 * @param command 命令类型pull
	 * @param step 
	 * @return
	 */
	public List<HttpResponceVO> pullReq(){
		CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        
        httpClient = HttpClients.createDefault();
        HttpPost httpPost = createHttpConnection(); // httpPost = "http://172.16.1.111:8080"
        
		StringBody command = new StringBody(NetworkUtils.PULL, ContentType.create("text/plain", Consts.UTF_8));
		StringBody step = new StringBody("all", ContentType.create("text/plain", Consts.UTF_8));
		
		HttpEntity reqEntity = MultipartEntityBuilder.create()
				.addPart(NetworkUtils.COMMAND, command)
				.addPart(NetworkUtils.STEP, step)
				.build();
		httpPost.setEntity(reqEntity);
		
		try {
        	// 发起请求 并返回请求的响应
			response = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	/**
	 * 发送每个文件都会调用一次
	 * @param commit 此次提交的版本号
	 * @param filePath 文件的绝对路径
	 * @param step 第i个文件
	 */
	private void pushReq2(StringBody commit, String filePath, int step) {
		CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        
        httpClient = HttpClients.createDefault();
        HttpPost httpPost = createHttpConnection();
        
        // 把文件转换成流对象FileBody
//        FileBody bin = new FileBody(new File(filePath));
        String midfile = ToMidFile.toMidFile(filePath);  // 将上传的文件先转换成中间文件
        System.out.println("filePath: " + filePath);
        System.out.println("midfile: " + midfile);
//        String midFileName = filePath.substring(0, filePath.lastIndexOf("/")) + "/tmp" + filePath.substring(filePath.lastIndexOf("/"), filePath.length());
//        midFileName = writeToFile(midfile, midFileName);
//        FileBody bin = new FileBody(new File(midFileName));
        
//        String midfile = ToMidFile.toMidFile(filePath);
//        StringBody bin = new StringBody(midfile, ContentType.create("text/plain", Consts.UTF_8));
        
        String fileName = getFileNameFromPath(filePath); // 根据文件路径拿到文件名称
        StringBody command = new StringBody(NetworkUtils.PUSH, ContentType.create("text/plain", Consts.UTF_8));
        StringBody stepBody = new StringBody(step+"", ContentType.create("text/plain", Consts.UTF_8));
        
        HttpEntity reqEntity = MultipartEntityBuilder.create()
        		.addPart(NetworkUtils.COMMAND, command)
        		.addPart(NetworkUtils.COMMIT, commit)
        		.addPart("fileName", new StringBody(fileName, ContentType.create("text/plain", Consts.UTF_8)))
        		.addPart("fileContent", new StringBody(midfile, ContentType.create("text/plain", Consts.UTF_8)))
        		.addPart(NetworkUtils.STEP, stepBody)
        		.build();
        httpPost.setEntity(reqEntity);
        
        try {
        	// 发起请求 并返回请求的响应
			response = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        int status = response.getStatusLine().getStatusCode();
        if (status == 200) { // 成功返回，说明此文件发送成功
		} else {

		}
	}
	
	
	private String writeToFile(String fileContent, String fileName) {
		fileName = fileName.substring(0, fileName.lastIndexOf(".")) + "mid";
		try {  
			File file = new File(fileName);
			if (!file.exists()) {
			    new File(fileName.substring(0, fileName.lastIndexOf("/"))).mkdirs();
			    file.createNewFile();
			}
            OutputStream os = new FileOutputStream(file);  
            os.write(fileContent.getBytes());
            os.flush();  
            os.close();  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
		return fileName;
	}
	
	/**
	 * 传输完文件后向服务器确认的请求，当服务器返回的是Processing时，需要反复提交，其余情况下说明服务器处理完成
	 * @param push 提交操作
	 * @param commit 此次的版本号
	 * @return
	 */
	private String pushReq3(StringBody push, StringBody commit) {
		CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        
        httpClient = HttpClients.createDefault();
        HttpPost httpPost = createHttpConnection();
        
        StringBody result = new StringBody("result", ContentType.create("text/plain", Consts.UTF_8));
        
        HttpEntity reqEntity = MultipartEntityBuilder.create()
        		.addPart(NetworkUtils.COMMAND, push)
        		.addPart(NetworkUtils.COMMIT, commit)
        		.addPart(NetworkUtils.STEP, result)
        		.build();
        httpPost.setEntity(reqEntity);
        
        try {
        	// 发起请求 并返回请求的响应
			response = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Connections with server had been closed.", "Error occur",JOptionPane.PLAIN_MESSAGE);
		}
		
        // 获取响应对象
        HttpEntity resEntity = response.getEntity();
        int status = response.getStatusLine().getStatusCode();
        if (status == 200) { // 成功返回，说明此文件发送成功
        	String res = "Processing";
			try {
				res = EntityUtils.toString(resEntity, Charset.forName("UTF-8"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return res;
		} else {

		}
        
		return "";
	}
	
	private String getFileNameFromPath(String fullPath) {
		int last = fullPath.lastIndexOf("/") + 1;
		return fullPath.substring(last, fullPath.length());
	}
	
	private String generateHashValueByTime() {
		String time = System.currentTimeMillis()+"";
		return NetworkUtils.getMD5(time.getBytes());
	}
	
	/**
	 * 向服务器获取所有
	 * @return
	 */
	public List<String> generatePullReq() {
		CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        
        httpClient = HttpClients.createDefault();
        HttpPost httpPost = createHttpConnection();
        
        StringBody command = new StringBody(NetworkUtils.PULL, ContentType.create("text/plain", Consts.UTF_8));
        StringBody step = new StringBody("log", ContentType.create("text/plain", Consts.UTF_8));
        
        HttpEntity reqEntity = MultipartEntityBuilder.create()
        		.addPart(NetworkUtils.COMMAND, command)
        		.addPart(NetworkUtils.STEP, step)
        		.build();
        httpPost.setEntity(reqEntity);
        
        try {
        	// 发起请求 并返回请求的响应
			response = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        List<String> result = null;
        
        // 获取响应对象
        HttpEntity resEntity = response.getEntity();
        int status = response.getStatusLine().getStatusCode();
        if (status == 200) { // 成功返回，获取到所有的commit版本号
        	try {
				String res = EntityUtils.toString(resEntity, Charset.forName("UTF-8"));
				// TODO 以空格来进行分隔
				result = Arrays.asList(res.split(" "));
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

		}
        
		return result;
	}
}
