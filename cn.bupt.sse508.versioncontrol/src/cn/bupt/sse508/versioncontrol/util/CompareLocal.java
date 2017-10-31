package cn.bupt.sse508.versioncontrol.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import midfile.json.graphiti.FromMidFileAboutMerge;
import midfile.json.graphiti.ToMidFile;

public class CompareLocal {
	
	public static JsonObject mergeObject = new JsonObject();
	public static JsonArray merge_nodeArray = new JsonArray();
	public static JsonArray merge_naviArray = new JsonArray();
	public static JsonArray merge_connectionArray = new JsonArray();
	
	public static JsonArray connection0Array;
	public static JsonArray connection1Array;
	public static JsonArray node0Array;
	public static JsonArray node1Array;
	
	public static void compareLocal(String currentDiagramPath, String currentDiagramName){		
		System.out.println("start compare local");
		
		String diagram0Str = ToMidFile.toMidFile("E:/Git/diagrams/flow.diagram");
		String diagram1Str = ToMidFile.toMidFile(currentDiagramPath);
		System.out.println(diagram0Str);
		
		Gson gson = new Gson();
		JsonParser parse =new JsonParser();
		JsonObject diagram0Obj= (JsonObject) parse.parse(diagram0Str);
		JsonObject diagram1Obj= (JsonObject) parse.parse(diagram1Str);
		
		/**
		 * 开始处理跳转
		 */
		System.out.println("\n-------------------");
		System.out.println("开始处理跳转");
		JsonArray navi0Array = ((JsonObject)((JsonObject)diagram0Obj.get("description")).get("-diagram")).get("navi").getAsJsonArray();
		JsonArray navi1Array = ((JsonObject)((JsonObject)diagram1Obj.get("description")).get("-diagram")).get("navi").getAsJsonArray();
		
		System.out.println(navi0Array.toString());
		System.out.println(navi1Array.toString());
		
		for (int i = 0; i < navi0Array.size(); i++) {
			//获取navi的值,一张图表的跳转标签只能有一个值，不可能存在多个。即一张图表可以跳转到多张图表，但是一张已经被关联过的图表不能再被其他图表关联，除非替换。
			String naviValue0String = ((JsonObject) (navi0Array.get(i).getAsJsonObject()).get("businessObjects")).get("@href").getAsString();
			String naviValue1String = ((JsonObject) (navi1Array.get(i).getAsJsonObject()).get("businessObjects")).get("@href").getAsString();
			System.out.println(naviValue0String);
			System.out.println(naviValue1String);
			
			//比较navi0和navi1的值
			if (naviValue1String.equals(naviValue0String)) {
				//跳转值相同，不做任何操作				
			}else {
				//跳转值不同，这是navi1新添加的跳转，保留navi1对该跳转的添加状态，将navi0的值记录到合并文件中
				//记录合并：替换
				System.out.println("记录合并：添加navi0的值到merge_naviArray中");
				Map map = new HashMap();
				map.put("version", "diagram0");
				map.put("@href", naviValue0String);
								
				String mapString = gson.toJson(map); // 将java对象转换成json字符串
				System.out.println(mapString);
				JsonElement mapElement = parse.parse(mapString); // 将json字符串转换成json对象
				merge_naviArray.add(mapElement);
				mergeObject.add("merge_navi", merge_naviArray);
				
				System.out.println(mergeObject.toString());		
				System.out.println("跳转处理结束");		
			}
		} 
		
		
		/**
		 * 开始处理连线
		 */
		System.out.println("\n\n--------------------");
		System.out.println("开始处理连线");
		connection0Array = ((JsonObject)((JsonObject)diagram0Obj.get("description")).get("-diagram")).get("connections").getAsJsonArray();
		connection1Array = ((JsonObject)((JsonObject)diagram1Obj.get("description")).get("-diagram")).get("connections").getAsJsonArray();		
		System.out.println(connection0Array.toString());	
		System.out.println(connection1Array.toString());
			
		// 遍历diagram1中的连线
		for (int i = 0; i < connection1Array.size(); i++) {
			String connection1IdString = ((JsonObject) connection1Array.get(i).getAsJsonObject()).get("@conn_id").getAsString();
//			System.out.println("diagram1: " + connection1IdString);
			boolean flag = findConnectionById(connection1IdString, "diagram1");
			if (flag) { // 在diagram1中存在与diagram0中相同的连线
				
			}else { // 该连线在diagram1中存在，在diagram0中不存在，这是diagram1新添加的连线，保留该连线，记录合并：添加
				System.out.println("这是diagram1新添加的连线，记录合并：添加，将该连线添加到merge_connectionArray中");
				Map map = new HashMap();
				map.put("conn_id", connection1IdString);
				map.put("action", "add");
				String mapStr = gson.toJson(map);
				JsonElement mapElement = parse.parse(mapStr);
				merge_connectionArray.add(mapElement);
//				System.out.println(merge_connectionArray.toString());
			}
		}
		
		// 遍历diagram0中的连线
		for (int i = 0; i < connection0Array.size(); i++) {
			String connection0IdString = ((JsonObject) connection0Array.get(i).getAsJsonObject()).get("@conn_id").getAsString();
//			System.out.println("diagram0: " + connection0IdString);
			boolean flag = findConnectionById(connection0IdString, "diagram0");
			if (flag) { // 在diagram0中存在与diagram1中相同的连线
				
			}else { // 该连线在diagram0中存在，在diagram1中不存在，这是diagram1删除的连线，保留该连线，记录合并：删除
				System.out.println("这是diagram1删除的连线，记录合并：删除，将该连线添加到merge_connectionArray中，并将该连线添加进diagram1图表的连线中");
				// 拿到被diagram1删除的连线对象,将其添加进diagram1图表连线数组中
				JsonObject deleteObject = connection0Array.get(i).getAsJsonObject();
				System.out.println("被删除的连线: " + deleteObject.toString());
				connection1Array.add(deleteObject);				
				Map map = new HashMap();
				map.put("conn_id", connection0IdString);
				map.put("action", "delete");
				String mapStr = gson.toJson(map);
				JsonElement mapElement = parse.parse(mapStr);
				merge_connectionArray.add(mapElement);
//				System.out.println(merge_connectionArray.toString());
			}
		}
		mergeObject.add("merge_connection", merge_connectionArray);
		System.out.println(mergeObject.toString());
		System.out.println("连线处理结束");
		
		
		/**
		 * 开始处理节点
		 */
		System.out.println("\n\n---------------------");
		System.out.println("开始处理节点");
		
		Queue<JsonElement> node0Queue = new LinkedList<JsonElement>();
		Queue<JsonElement> node1Queue = new LinkedList<JsonElement>();
		
		node0Array = ((JsonObject)((JsonObject)diagram0Obj.get("description")).get("-diagram")).get("node").getAsJsonArray();
		node1Array = ((JsonObject)((JsonObject)diagram1Obj.get("description")).get("-diagram")).get("node").getAsJsonArray();
		System.out.println("node0Array: " + node0Array.toString());
		System.out.println("node1Array: " + node1Array.toString());
		
//		node0Queue.offer(node0Array);
//		node1Queue.offer(node1Array);
		
		// 遍历diagram1中的节点
		for (int i = 0; i < node1Array.size(); i++) {
			String node1IdString = node1Array.get(i).getAsJsonObject().get("@shape_id").getAsString();
			System.out.println("node1IdString: " + node1IdString);
			// 根据node1的id在node0中寻找相同id的节点下标
			int j = findNodeById(node1IdString, "diagram1");
//			System.out.println(j);
			
			if (j >= 0) {
				// 该节点在node1中存在，在node0中也存在
				// 比较是否所有属性相同
				
				// 合并anchors
				JsonObject node1AnchorObject = (JsonObject) node1Array.get(i).getAsJsonObject().get("anchors");
				JsonObject node0AnchorObject = (JsonObject) node0Array.get(j).getAsJsonObject().get("anchors");
				mergeAnchors(node1AnchorObject, node0AnchorObject);
				
				JsonObject subNode0Object = (JsonObject) node0Array.get(j);
				JsonObject subNode1Object = (JsonObject) node1Array.get(i);
				node0Queue.offer(subNode0Object);
				node1Queue.offer(subNode1Object);
								
				// 比较节点的text值是否相同，若不相同，记录合并：修改，将node0的text值添加进合并文件中
				JsonArray nodeText1Array = ((JsonObject) node1Array.get(i)).get("ext").getAsJsonObject().get("text").getAsJsonArray();
				JsonArray nodeText0Array = ((JsonObject) node0Array.get(j)).get("ext").getAsJsonObject().get("text").getAsJsonArray();				
				if (nodeText1Array.size() > 0) {
					String text1String = nodeText1Array.get(0).getAsJsonObject().get("style").getAsJsonObject().get("@value").getAsString();
					String text0String = nodeText0Array.get(0).getAsJsonObject().get("style").getAsJsonObject().get("@value").getAsString();
					System.out.println("text1String: " + text1String);
					boolean isSame = propertySame(nodeText0Array, text1String);
					if (!isSame) { // 相同节点的text值不同，记录合并：修改modify
						Map map = new HashMap();
						map.put("shap_id", node1IdString);
						map.put("action", "modify");
						map.put("text", text0String);
						String mapString = gson.toJson(map);
						JsonElement mapElement = parse.parse(mapString);
						merge_nodeArray.add(mapElement);
//						mergeObject.add("merge_node", merge_nodeArray);
//						System.out.println(mergeObject.toString());
					}else {
						// 相同节点text值也相同，不做处理
						// 可以考虑将该节点弹出队列
					}
				}
				
			}else {
				// 该节点在node1中存在，在node0中不存在，这是node1添加的节点。
				JsonArray nodeText1Array = ((JsonObject) node1Array.get(i)).get("ext").getAsJsonObject().get("text").getAsJsonArray();
				if (nodeText1Array.size() > 0) {
					String text1String = nodeText1Array.get(0).getAsJsonObject().get("style").getAsJsonObject().get("@value").getAsString();
					System.out.println("text1String: " + text1String);
					// 记录合并：添加
					Map map = new HashMap();
					map.put("shap_id", node1IdString);
					map.put("action", "add");
					String mapString = gson.toJson(map);
					JsonElement mapElement = parse.parse(mapString);
					merge_nodeArray.add(mapElement);					
				}
			}
		}
		
		// 遍历diagram0中的节点
		for (int j = 0; j < node0Array.size(); j++) {
			String node0IdString = node0Array.get(j).getAsJsonObject().get("@shape_id").getAsString();
//			System.out.println("node0IdString:　" + node0IdString);
			// 寻找node1中拥有相同节点id的节点下标
			int i = findNodeById(node0IdString, "diagram0");
//			System.out.println(i);
			if (i < 0) {  
				// 该节点在node0中存在，在node1中不存在，这是node1删除的节点,记录合并：删除，并将该节点保存到diagram1中
				// 记录合并：删除
				Map map = new HashMap();
				map.put("shap_id", node0IdString);
				map.put("action", "delete");
				String mapString = gson.toJson(map);
				JsonElement mapElement = parse.parse(mapString);
				merge_nodeArray.add(mapElement);
				
				// 将该节点保存到diagram1中
				JsonObject nodeDeleteObject = node0Array.get(j).getAsJsonObject();
				node1Array.add(nodeDeleteObject);
				
				/**
				 *  处理与该节点相关联的其他节点的anchor
				 *  拿到该节点的出连线和入连线
				 */
				
				JsonObject nodeDeleteAnchor = (JsonObject) node0Array.get(j).getAsJsonObject().get("anchors");
				String nodeDeleteAnchorIncomming = nodeDeleteAnchor.get("@incomingConnections").getAsString();
				String nodeDeleteAnchorOutgoing = nodeDeleteAnchor.get("@outgoingConnections").getAsString();
				System.out.println("nodeDeleteAnchorIncomming: " + nodeDeleteAnchorIncomming);
				System.out.println("nodeDeleteAnchorOutgoing: " + nodeDeleteAnchorOutgoing);
				
				// 处理前节点的连线问题
				String preNodeIdString = nodeDeleteAnchorIncomming.split("#")[0];
				JsonObject preNode1Object= getNode1ById(preNodeIdString);
				String preNode1OutgoingString = preNode1Object.get("anchors").getAsJsonObject().get("@outgoingConnections").getAsString();				
				preNode1Object.get("anchors").getAsJsonObject().remove("@outgoingConnections");
				System.out.println("preNode1OutgoingString: " + preNode1OutgoingString);
				String newNode1OutgoingString  = preNode1OutgoingString + nodeDeleteAnchorIncomming;
				String preValueString = gson.toJson(newNode1OutgoingString);
				JsonElement preElement = parse.parse(preValueString);
				preNode1Object.get("anchors").getAsJsonObject().add("@outgoingConnections", preElement);
				
				// 处理后节点的问题
				String[] nextNodeIdAllStrings = nodeDeleteAnchorOutgoing.split(" ");
				System.out.println("1111: " + nextNodeIdAllStrings.length);
				for (int k = 0; k < nextNodeIdAllStrings.length; k++) {
					String nextNodeIdString = nextNodeIdAllStrings[k].split("#")[1];					
					JsonObject nextNode1Object = getNode1ById(nextNodeIdString);
					System.out.println("222: " + nextNodeIdString);
					String nextNode1IncomingString = nextNode1Object.get("anchors").getAsJsonObject().get("@incomingConnections").getAsString();
					nextNode1Object.get("anchors").getAsJsonObject().remove("@incomingConnections");
					String newNode1Incoming = nextNode1IncomingString + nextNodeIdAllStrings[k] + " ";
					System.out.println("333: " + newNode1Incoming);
					String nextValueString = gson.toJson(newNode1Incoming);
					JsonElement nextElement = parse.parse(nextValueString);
					nextNode1Object.get("anchors").getAsJsonObject().add("@incomingConnections", nextElement);
				}
				
				
//				JsonObject nodeDeleteAnchor = (JsonObject) node0Array.get(j).getAsJsonObject().get("anchors");
//				String nodeDeleteAnchorIncomming = nodeDeleteAnchor.get("@incomingConnections").getAsString();
//				String nodeDeleteAnchorOutgoing = nodeDeleteAnchor.get("@outgoingConnections").getAsString();
//				System.out.println("nodeDeleteAnchorIncomming: " + nodeDeleteAnchorIncomming);
//				System.out.println("nodeDeleteAnchorOutgoing: " + nodeDeleteAnchorOutgoing);
//				
//				String preNodeIdString = nodeDeleteAnchorIncomming.split("#")[0];
//				String nextNodeIdString = nodeDeleteAnchorOutgoing.split("#")[1];
//				System.out.println("nextNodeIdString: " + nextNodeIdString);
//				
//				// 根据节点id拿到diagram1中该节点的json对象
//				JsonObject preNode1Object= getNode1ById(preNodeIdString);
//				JsonObject nextNode1Object= getNode1ById(nextNodeIdString);
//				System.out.println("preNode1Object: " + preNode1Object);
//				System.out.println("nextNode1Object: " + nextNode1Object);
//
//				// 在preNode1Object的anchor中的outgoing中添加nodeDeleteAnchorIncomming
//				String preNode1OutgoingString = preNode1Object.get("anchors").getAsJsonObject().get("@outgoingConnections").getAsString();				
//				preNode1Object.get("anchors").getAsJsonObject().remove("@outgoingConnections");
//				System.out.println("preNode1OutgoingString: " + preNode1OutgoingString);
//				String newNode1OutgoingString  = preNode1OutgoingString + nodeDeleteAnchorIncomming;
//				String preValueString = gson.toJson(newNode1OutgoingString);
//				JsonElement preElement = parse.parse(preValueString);
//				preNode1Object.get("anchors").getAsJsonObject().add("@outgoingConnections", preElement);
//				System.out.println("11111111111: " + preNode1Object.get("anchors").getAsJsonObject().toString());
//				
//				// 在nextNode1Object的anchor中的incomming中添加nodeDeleteAnchorOutgoing
//				String nextNode1IncomingString = nextNode1Object.get("anchors").getAsJsonObject().get("@incomingConnections").getAsString();
//				System.out.println("nextNode1IncomingString: " + nextNode1IncomingString);
//				nextNode1Object.get("anchors").getAsJsonObject().remove("@incomingConnections");
//				String newNode1Incoming = nextNode1IncomingString + nodeDeleteAnchorOutgoing;
//				String nextValueString = gson.toJson(newNode1Incoming);
//				JsonElement nextElement = parse.parse(nextValueString);
//				nextNode1Object.get("anchors").getAsJsonObject().add("@incomingConnections", nextElement);
//				System.out.println("11111111111: " + nextNode1Object.get("anchors").getAsJsonObject().toString());
//				System.out.println(preNode1Object.toString());
//				System.out.println(nextNode1Object.toString());
			}else {
				// 已经对相同节点做过了处理，此处无需再做处理
			}
		}
		mergeObject.add("merge_node", merge_nodeArray);
		System.out.println(mergeObject.toString());
		System.out.println("node1Array: " + node1Array.toString());
		
		// 将内容写入文件（diagram1和合并文件）
		System.out.println(diagram1Obj.toString());
		
		/**
		 *  在用户当前编辑的文件diagram1Obj上根据描述文件mergeObject来进行解析和展示工作
		 */
//		FromMidFileAboutMerge.fromMidFileAboutMerge(diagram1Obj.toString(), mergeObject);
		String newDiagramXml = FromMidFileAboutMerge.fromMidFileAboutMerge(diagram1Obj.toString(), mergeObject);
		merge_nodeArray = new JsonArray();
		merge_connectionArray = new JsonArray();
		merge_naviArray = new JsonArray();
		
		/**
		 * 用新生成的新diagram1替代原有的diagram1图表文件
		 */
		File file = new File("E:/Git/buptsse2015/runtime-EclipseApplication/test/src/flow/newFlow.diagram"); // 文件名字
		writeToFile(newDiagramXml, file);

	}
	
	/**
	 * 将字符串内容写入到某个文件中
	 * @param content String，字符串内容
	 * @param file File，文件对象
	 */
	private static void writeToFile(String content, File file) {
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
	 * 通过id拿到节点对象
	 * @param id
	 * @return
	 */
	public static JsonObject getNode1ById(String id){
		for (int i = 0; i < node1Array.size(); i++) {
			String node1IdString = node1Array.get(i).getAsJsonObject().get("@shape_id").getAsString();
//			System.out.println("node11111111111111111: " + node1IdString);
			if (id.contains(node1IdString)) {
				return node1Array.get(i).getAsJsonObject();
			}
		}
		return null;		
	}
	
	/**
	 * 比较相同节点id的text值是否相同
	 * @param nodeText0Array
	 * @param text1String
	 * @return
	 */
	public static boolean propertySame(JsonArray nodeText0Array, String text1String){
		if (nodeText0Array.size() > 0) {
			String text0String = nodeText0Array.get(0).getAsJsonObject().get("style").getAsJsonObject().get("@value").getAsString();
			if (text1String.equals(text0String)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 *  合并相同节点的incomming和outgoing
	 * @param node1AnchorObject
	 * @param node0AnchorObject
	 */
	public static void mergeAnchors(JsonObject node1AnchorObject, JsonObject node0AnchorObject){
		String node1Incomming = node1AnchorObject.get("@incomingConnections").getAsString();
		String node1Outgoing = node1AnchorObject.get("@outgoingConnections").getAsString();
		String node0Incomming = node0AnchorObject.get("@incomingConnections").getAsString();
		String node0Outgoing = node0AnchorObject.get("@outgoingConnections").getAsString();
		
	}
	
	/**
	 * 通过节点id寻找拥有相同节点id的下标
	 * @param id
	 * @param diagram
	 * @return
	 */
	public static int findNodeById(String id, String diagram){
		if (diagram.equals("diagram1")) {
			for (int j = 0; j < node0Array.size(); j++) {
				String node0IdString = node0Array.get(j).getAsJsonObject().get("@shape_id").getAsString();
				if (id.equals(node0IdString)) {
					return j;
				}
			}
		}else {
			for (int j = 0; j < node1Array.size(); j++) {
				String node1IdString = node1Array.get(j).getAsJsonObject().get("@shape_id").getAsString();
				if (id.equals(node1IdString)) {
					return j;
				}
			}
		}
		return -1;		
	}
	
	/**
	 * 比较两张图表中的连线id是否相同
	 * @param id
	 * @param diagram
	 * @return
	 */
	public static boolean findConnectionById(String id, String diagram){
		
		if (diagram.equals("diagram1")) {
			for (int i = 0; i < connection0Array.size(); i++) {
				String connection0IdString = ((JsonObject) connection0Array.get(i).getAsJsonObject()).get("@conn_id").getAsString();
				if (id.equals(connection0IdString)) {
//					System.out.println("diagram0: " + connection0IdString);
					return true;
				}
			}
		}else {
			for (int i = 0; i < connection1Array.size(); i++) {
				String connection1IdString = ((JsonObject) connection1Array.get(i).getAsJsonObject()).get("@conn_id").getAsString();
				if (id.equals(connection1IdString)) {
//					System.out.println("diagram1: " + connection1IdString);
					return true;
				}
			}
		}
		
		return false;		
	}
	
	/**
	 * 读取文件内容
	 * @param fileName
	 * @return
	 */
	public static String readToString(String fileName) {  
        String encoding = "UTF-8";  
        File file = new File(fileName);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            in.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        try {  
            return new String(filecontent, encoding);  
        } catch (UnsupportedEncodingException e) {  
            System.err.println("The OS does not support " + encoding);  
            e.printStackTrace();  
            return null;  
        }  
    }

}
