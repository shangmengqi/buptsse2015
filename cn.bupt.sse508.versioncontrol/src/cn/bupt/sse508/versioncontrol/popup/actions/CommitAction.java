package cn.bupt.sse508.versioncontrol.popup.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.json.JSONObject;

import cn.bupt.sse508.versioncontrol.network.HttpAgent;
import cn.bupt.sse508.versioncontrol.network.HttpResponceVO;
import cn.bupt.sse508.versioncontrol.util.ProjectUtil;
import graeditor.utils.ValueUtil;
import midfile.json.graphiti.FromMidFile;
import midfile.json.graphiti.Utils;

/**
 * 完成【提交】流程的主类，包括从工程目录中读取文件，发送给服务器，接收返回，在中间文件中添加冲突信息，将文件覆盖回工程目录中，关闭所有打开的编辑窗口，打开冲突的图表
 * @author shhqin
 *
 */
public class CommitAction implements IObjectActionDelegate{
	private List<String> versionList = new ArrayList<>();
	
	public CommitAction() {
		super();
		versionList.add("new base");
	}

	/* 
	 * 执行push功能的主函数
	 */
	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		push();
		
//		showDialog();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * 根据文件名并指导其相对路径，取得该文件的IFile对象
	 * @author lifeng
	 * @param fileName
	 * @return
	 * IFile
	 * @datetime 2012-9-5 上午07:27:47
	 */
	private IFile getFile(String fileName) {
		IProject prj = ProjectUtil.getCurrentProject();
		if (prj == null) {
			return null;
		}
		return prj.getFile("/src/diagrams/" + fileName);
	}
	
	private String getLocation() {
		return ProjectUtil.getCurrentProject().getLocation().toString();
	}
//	
//	
//	public void upload(String localFile){
//        CloseableHttpClient httpClient = null;
//        CloseableHttpResponse response = null;
//        try {
//            httpClient = HttpClients.createDefault();
////            FileBody bin = new FileBody(new File("Test.txt"));
//            
//            // 把一个普通参数和文件上传给下面这个地址 是一个servlet
//            HttpPost httpPost = new HttpPost("http://10.110.144.104:8080/");
//            
//            String path = getLocation();
//            
//            // 把文件转换成流对象FileBody
//            FileBody bin = new FileBody(new File(path + "/src/diagrams/chess.diagram"));
//
//            StringBody userName = new StringBody("Scott", ContentType.create(
//                    "text/plain", Consts.UTF_8));
//            StringBody password = new StringBody("123456", ContentType.create(
//                    "text/plain", Consts.UTF_8));
//
//            HttpEntity reqEntity = MultipartEntityBuilder.create()
//                    // 相当于<input type="file" name="file"/>
//                    .addPart("file", bin)
//                    
//                    // 相当于<input type="text" name="userName" value=userName>
//                    .addPart("userName", userName)
//                    .addPart("pass", password)
//                    .build();
//
//            httpPost.setEntity(reqEntity);
//
//            // 发起请求 并返回请求的响应
//            response = httpClient.execute(httpPost);
//            
//            System.out.println("The response value of token:" + response.getFirstHeader("token"));
//                
//            // 获取响应对象
//            HttpEntity resEntity = response.getEntity();
//            if (resEntity != null) {
//                // 打印响应长度
//                System.out.println("Response content length: " + resEntity.getContentLength());
//                // 打印响应内容
//                System.out.println(EntityUtils.toString(resEntity, Charset.forName("UTF-8")));
//            }
//            
//            // 销毁
//            EntityUtils.consume(resEntity);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if(response != null){
//                    response.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            
//            try {
//                if(httpClient != null){
//                    httpClient.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
	
	/**
	 * 让用户输入本次的base
	 * @return
	 */
	private String getBase() {
//		return JOptionPane.showInputDialog(null,"base num：\n","This commit is base on",JOptionPane.PLAIN_MESSAGE); 
		  
		return ((String) JOptionPane.showInputDialog(null, null, "Choose base", JOptionPane.PLAIN_MESSAGE, null, versionList.toArray(), versionList.get(0))).replace("\n", "");
	}
	
	private void showMessageDiaglog(List<String> conflictFiles) {
		if (conflictFiles.size() != 0) { // 有冲突
			JOptionPane.showMessageDialog(null, "Conflicts occur. Please refresh your project and solve conflicts before commit.", "Conflicts occur",JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void push() {
		// TODO 从配置文件中获取上一个版本的version
    	String base = "base";
    	
    	// 让用户从对话框选择base版本号
    	base = getBase();
    	if (null == base) {
			return;
		}
    	if (base.equals("new base")) {
    		versionList.clear();
    		versionList.add("new base");
    	}
    	
    	// TODO 弹出对话框让用户输入本次提交的描述
    	String description = "";
    	
    	String path = getLocation() + "/src/";
    	List<String> fileList = getDiagrams(path);
    	
    	// 获取服务器的返回结果
    	HttpAgent agent = HttpAgent.getInstance();
    	List<HttpResponceVO> resultList = agent.generatePushReq(base, description, fileList.size(), fileList);
    	
    	// 将中间文件转换成为xml文件
    	List<String> conflictFiles = convertToXML(resultList);
    	
    	closeAllTabAndOpenConflictsTab(conflictFiles);
    	showMessageDiaglog(conflictFiles);
    	
    	// TODO 持久化版本号
    	// 临时存储版本号
    	versionList.add(resultList.get(0).versionNo);
    }

	/**
	 * 获取当前工作目录下的diagram文件
	 * @return
	 */
	public List<String> getDiagrams(String path) {
		List<IFile> files = getDiagramFiles(ProjectUtil.getCurrentProject());
		List<String> fileContent = new ArrayList<String>();
		for (int i = 0; i < files.size(); i++) {
//			String content = Utils.readFileByLines(path+files.get(i).getName());
			String filename = path+files.get(i).getName();
			fileContent.add(filename);
		}
		
		return fileContent;
	}
	
	/**
	 * 递归的搜索所有.diagrams文件
	 * @param folder
	 * @return
	 */
	private List<IFile> getDiagramFiles(IContainer folder) {
		final List<IFile> ret = new ArrayList<IFile>();
		try {
			final IResource[] members = folder.members();
			for (final IResource resource : members) {
				if (resource instanceof IContainer) {
					ret.addAll(getDiagramFiles((IContainer) resource));
				} else if (resource instanceof IFile) {
					final IFile file = (IFile) resource;
					if (file.getName().endsWith(".diagram")) { //$NON-NLS-1$
						ret.add(file);
					}
				}
			}
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * 将服务器返回的中间文件转换成为XML文件，在xml文件中添加必要的冲突描述信息
	 * @param resultList
	 * @return 冲突的文件名，便于插件重新打开这些编辑窗口
	 */
	public List<String> convertToXML(List<HttpResponceVO> resultList) {
		{
			//获取返回结果的总体状态 
			HttpResponceVO responce = resultList.get(0);
			if (!responce.result.equals("OK")) { // 不为OK的返回，需要覆盖原有文件
				// 删除该工程目录下的所有diagram文件
				deleteAllDiagrams();
			} else {
				JOptionPane.showMessageDialog(null, "Your diagrams are commited to Server.\nVersion Num: "+responce.versionNo, "Commit complete",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
		String path = getLocation() + "/src/";
		List<String> conflictFileNames = new ArrayList<String>();
		
		for (int i = 1; i < resultList.size(); i++) {
			HttpResponceVO responce = resultList.get(i);
			if (responce.result.equals("OK")) { // 说明没有冲突
				String xml = FromMidFile.fromMidFile(responce.fileContent, null);
				File file = new File(responce.fileName);
				writeToFile(xml, file);
			} else { // 有冲突
				String xml = FromMidFile.fromMidFile(responce.fileContent, responce.conflictList);
				File file = new File(responce.fileName);
				writeToFile(xml, file);
				String relativeFileName = responce.fileName.substring(responce.fileName.lastIndexOf("/")+1, responce.fileName.length());
				conflictFileNames.add(relativeFileName);
			}
		}
		
		
		return conflictFileNames;
	}
	
	/**
	 * 删除该工程目录下的所有.diagrams文件
	 * 
	 */
	private void deleteAllDiagrams() {
		List<IFile> files = getDiagramFiles(ProjectUtil.getCurrentProject());
		try {
			for (int i = files.size() - 1; i >= 0; i--) {
				files.get(i).delete(true, null);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 关掉当前所有的编辑窗口，并打开所有发生冲突的图表
	 * @param conflictFiles
	 */
	public void closeAllTabAndOpenConflictsTab(List<String> conflictFiles) {
		if (conflictFiles.size() > 0) {
			// 关闭当前所有窗口
			IWorkbenchPage workbenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			workbenchPage.closeAllEditors(true);
			// 打开冲突的编辑窗口
			open(conflictFiles);
		}
	}
	
	/**
	 * 打开列表中所有的图表
	 * @param fileNames
	 */
	public void open(List<String> fileNames) {
		for (int i = 0; i < fileNames.size(); i++) {
			IWorkbenchPage wbPage = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			IFile file = getFile(fileNames.get(i));
			try {
				if (file != null) {
					IDE.openEditor(wbPage, file);
				}
			} catch (PartInitException e) {
				e.printStackTrace();
			}
			return;
		}
	}
	
	/**
	 * 将字符串内容写入到某个文件中
	 * @param content String，字符串内容
	 * @param file File，文件对象
	 */
	private void writeToFile(String content, File file) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将冲突描述文件保存起来
	 * @param resultList
	 */
	private void saveConflictDescription(List<HttpResponceVO> resultList) {
		for (int i = 0; i < resultList.size(); i++) {
			List<JSONObject> conflictList = resultList.get(i).conflictList;
			if (conflictList != null && conflictList.size() != 0) {
				
			}
		}
	}
	
	/**
	 * 小论文测试用
	 */
	private void showDialog() {
		MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				ValueUtil.TITLE_NODE_WITH_CONFLICT, null, "Version A has Text 'Suspending Order'\nVersion B has Text 'OrderList'\nWhich to keep?", MessageDialog.ERROR, 
				new String[] { "Version A", "Version B" }, 0);
		int result = dialog.open();
	}
}


