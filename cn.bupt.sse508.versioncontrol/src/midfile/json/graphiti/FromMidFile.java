package midfile.json.graphiti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import graeditor.utils.ValueUtil;

/**
 * 提供中间文件到xml的转换，需要注意的是，最后生成的xml字符串中，不能包含多余的信息，因此在转换完成后，需要将所有的存储中间信息的tag都删掉
 * @author shhqin
 *
 */
public class FromMidFile {
	// 所有节点的数组
	public static List<JSONObject> allNodeList;
	// 用于存储节点id与其在allNodeList中下标的map，为了节省遍历allNodeList的时间
	public static Map<String, Integer> allNodeMap;
	// 用于层级遍历节点的队列
	public static Queue<LayeredNode> queue;
	// 用于生成PictogramLinks的StringBuilder
	public static StringBuilder pictogramLinks;
	// 用于存储所有连线的map
	public static Map<String, JSONObject> connectionMap;
	public static List<LayeredBONode> layeredBOList;
	// 用于存储连线与节点下标的数组
	public static List<IndexedConnection> connectionList;
	// namespace
	public static String namespace;
	//connections
	public static Object connections;
	
	/**
	 * 提供将中间文件字符串转换成为xml的功能
	 * @param content
	 * @return
	 */
	public static String fromMidFile(String content, List<JSONObject> conflictList) {
		// 对冲突列表进行处理，便于在对节点的扫描中一并处理
		Map<String, JSONObject> conflictMap = new HashMap<String, JSONObject>();
		if (null != conflictList) { //存在冲突
			for (int i = 0; i < conflictList.size(); i++) {
				String id = conflictList.get(i).optString("shape_id");
				System.out.println("i = " + i);
				System.out.println("id = " + id + " : " + conflictList.get(i));
				conflictMap.put(id, conflictList.get(i));
			}
		}
		//////////////////----
		
		allNodeList = new ArrayList<JSONObject>();
		allNodeMap = new HashMap<String, Integer>();
		pictogramLinks = new StringBuilder();
		connectionList = new ArrayList<IndexedConnection>();
		
		// 对字符串进行替换处理
		content = content.replace("node", ValueUtil.CHILDREN); // 会将nodelist改成childrenlist
		content = content.replace("style", "graphicsAlgorithm");
		content = content.replace("-diagram", ValueUtil.DIAGRAM);
		content = content.replace("description", ValueUtil.XMI);
		content = content.replace("navi", "link");
		
		JSONObject midfile = new JSONObject(content); // 接收到的经过字符串转换后的json文件
		System.out.println("midfile : " + midfile.toString());
		queue = new LinkedList<LayeredNode>();
		JSONObject xmi = midfile.optJSONObject(ValueUtil.XMI);
		System.out.println("xmi : " + xmi.toString());
		namespace = xmi.optString("@ns"); // 获取到该文件的nameapace,即structView
		System.out.println("namespace : " + namespace);
		JSONObject diagram = xmi.optJSONObject(ValueUtil.DIAGRAM); // 获取到pi:Diagram标签里的属性,用{}括起来的对象
		System.out.println("diagram : " + diagram.toString());
		
		//(shangmengqi add)先判断该图表是否含有连线
		if(diagram.has(ValueUtil.CONNECTIONS)){
			connections = diagram.opt(ValueUtil.CONNECTIONS); // 获取到标签为connection的属性内容
			System.out.println("connections : " + connections.toString());
		}else {
			connections = null;
		}
		
//		Object connections = diagram.opt(ValueUtil.CONNECTIONS); // 获取到标签为connection的属性内容
//		System.out.println("connections : " + connections.toString());

		// 处理空的link数组的情况
		{
			JSONArray arr = diagram.optJSONArray("link"); // 解析出来的格式是数组类型，即用[]括起来的jsonObject
			if (arr.length() == 0) {
				diagram.remove("link"); // 删掉
			} else {
				JSONObject foo = arr.getJSONObject(0);
				if (foo.getJSONObject("businessObjects").getString("@href").equals("")) { // 空的href，需要删掉link
					diagram.remove("link"); // 删掉
				}else {
					// 不为空的情况，将其转换为xml文件 
				}
			}
		}
		
		// 先对connections进行遍历，构造一个hashmap
		connectionMap = new HashMap<String, JSONObject>();
		if(connections != null){
			if (connections instanceof JSONObject) { // 单个连线
				String connectionID = ((JSONObject) connections).optString("@conn_id");
				connectionMap.put(connectionID, (JSONObject) connections);
				((JSONObject) connections).accumulate("@index", "0");
			} else { // 连线数组
				JSONArray connectionArr = (JSONArray) connections;
				for (int i = 0; i < connectionArr.length(); i++) {
					String connectionID = connectionArr.getJSONObject(i).optString("@conn_id");
					connectionMap.put(connectionID, connectionArr.getJSONObject(i));
					connectionArr.getJSONObject(i).accumulate("@index", ""+i);
				}
			}
		}

		
		// 对节点的处理
		layeredBOList = new ArrayList<LayeredBONode>();
		LayeredNode lnode = new LayeredNode(diagram.opt(ValueUtil.CHILDREN), "0");
		
		queue.add(lnode);
		while (!queue.isEmpty()) {
			LayeredNode lNode = queue.poll();
			String currentLayer = lNode.layer;
			if (lNode.childList instanceof JSONObject) { // 单个节点
				JSONObject node = (JSONObject) lNode.childList;
				System.out.println("nodeqqqqqqqqqqqqqqqqqqqqqq: " + node.toString());
				processNode(node, currentLayer+"/0", connections);
				
			} else { // 节点列表
				JSONArray nodes = (JSONArray) lNode.childList;
				for (int i = 0; i < nodes.length(); i++) {
					System.out.println("nodesqqqqqqqqqqqqqqqqqqqqqqqqqq: " + nodes.length());
					processNode(nodes.getJSONObject(i), currentLayer+"/"+i, connections);
				}
			}
		}
		
		// 以下是对连线的处理，将连线的start和end改为使用索引的标记
		if(connections != null){
			if (connections instanceof JSONObject) { // 单个连线
				processConnection((JSONObject) connections);
			} else { // 连线数组
				JSONArray connectionsArr = (JSONArray) connections;
				for (int i = 0; i < connectionsArr.length(); i++) {
					processConnection(connectionsArr.getJSONObject(i));
				}
			}
		}
//		if (connections instanceof JSONObject) { // 单个连线
//			processConnection((JSONObject) connections);
//		} else { // 连线数组
//			JSONArray connectionsArr = (JSONArray) connections;
//			for (int i = 0; i < connectionsArr.length(); i++) {
//				processConnection(connectionsArr.getJSONObject(i));
//			}
//		}
		
		// 下面生成图表的BusinessObject信息和节点link值
		StringBuilder boXMLsb = new StringBuilder();
		String layer = "";
		System.out.println("layeredBOList.size()22222222222222222222222222222222222: " + layeredBOList.size());
		
		if("com.graeditor.flow_model".equals(namespace)){
			for(int a = 0; a < allNodeList.size(); a++){
				int num = 0;
				num = a + 1;
				String tagName = allNodeList.get(a).optJSONObject("link").optString("@businessObjects");
				String str = dfs1(a, tagName, num);
				boXMLsb.append(str);				
			}				
		}else {
			for (int i = 0; i < layeredBOList.size(); i++) {
				int index = layeredBOList.get(i).index;
				layer = i+1+"";
				String tagName = allNodeList.get(index).optJSONObject("link").optString("@businessObjects");						
				System.out.println("allNodeList.size: " + allNodeList.size());
				System.out.println("index111111111111111111111111: " + index);
				System.out.println("tagName111111111111111111111111: " + tagName);
				System.out.println("layer11111111111111111111111111: " + layer);
				String str = dfs(index, tagName, layer);
				boXMLsb.append(str);
				System.out.println("boXMLsbaaaaaaaaaaaaaaaaaaaaaaaaaaaa: " + boXMLsb.toString());
			}
		}

		String boXMLStr = boXMLsb.toString();
		System.out.println("boXMLStrbbbbbbbbbbbbbbbbbbbbbbbb: " + boXMLStr);
		
		// 最后需要遍历所有元素，去掉多余的信息
		for (int i = 0; i < allNodeList.size(); i++) {
			JSONObject node = allNodeList.get(i);
			String id = node.optString("@shape_id");
			
			// 删除ext
			if (node.has("ext")) {
				node.remove("ext");
			}
			
			// 删除childrenlist，即nodelist
			if (node.has("childrenlist")) {
				node.remove("childrenlist");
			}
			
			// 删除shape_id
			if (node.has("@shape_id")) {
				node.remove("@shape_id");
			}
			
			// 删除layer
			if (node.has("@layer")) {
				node.remove("@layer");
			}
			
			// 删除空的children
			if (node.has(ValueUtil.CHILDREN)) {
				if (node.opt(ValueUtil.CHILDREN) instanceof JSONArray) {
					if (node.optJSONArray(ValueUtil.CHILDREN).length() == 0) {  // 空的node数组
						node.remove(ValueUtil.CHILDREN);
					}
				}
			}
			
			// 在节点中添加冲突信息
			if (conflictMap.containsKey(id)) { // 当前节点是否为冲突节点,containsKey()判断是否包含指定的键名
				System.out.println("conflictMap.containsKey(id) id = " + id);
				System.out.println("conflictMap: " + conflictMap.hashCode());
				JSONObject conflictInfo = conflictMap.get(id);
				System.out.println("conflictInfo: " + conflictInfo.toString());
				// 用于判断这个节点是否是一个删除冲突
				boolean isDeleted = true;
				if (conflictInfo.optString("isDeleted").equals("false")) {
					isDeleted = false;
				}
				
				JSONObject info = new JSONObject();
				JSONArray properties = node.optJSONArray("properties");
				if (isDeleted) { // 删除与其他的冲突，只需要在property中添加conflict_delete信息
					info.put("@key", "info");
					info.put("@value", ValueUtil.CONFLICT_DELETE);
					properties.put(info);
					
					// 将贴图换成虚线红框
					JSONObject graphicsAlgorithm = node.optJSONObject("graphicsAlgorithm");
					replaceImg(graphicsAlgorithm, isDeleted);
					
				} else { // 显示文字冲突
					info.put("@key", "info");
					info.put("@value", ValueUtil.CONFLICT_TEXT);
					properties.put(info);
					
					// 将冲突的另一个文字信息存入property中
					System.out.println("hahahahahahhahaha444444: ");
					
					//(shangmengqi add) 先进行判断是否含有conflict_key键，然后再进行后续操作
					if (conflictInfo.has("conflict_key")) {
						System.out.println("start to handle the conflict_text");
						String conflict_key = conflictInfo.optJSONArray("conflict_key").getString(0);
						String alternative_text = conflictInfo.optString(conflict_key);
						JSONObject alternative = new JSONObject();
						alternative.put("@key", ValueUtil.ALTERNATIVE_TEXT);
						alternative.put("@value", alternative_text);
						properties.put(alternative);
						System.out.println("handle the conflict_text end");
						
						// 将贴图换成实线红框
						JSONObject graphicsAlgorithm = node.optJSONObject("graphicsAlgorithm");	
						System.out.println("graphicsAlgorithm: " + graphicsAlgorithm);
						
						//(shangmengqi add)分情况展示冲突节点，替换贴图或者更换原来颜色						
						if(graphicsAlgorithm.has("@id")){
							replaceImg(graphicsAlgorithm, isDeleted);
						}else {
							System.out.println("更换冲突节点颜色");
							String background = graphicsAlgorithm.optString("@background");
							System.out.println("background: " + background);
							String new_background;
							new_background = background.substring(0, 11) + "1";
							graphicsAlgorithm.remove("@background");
							graphicsAlgorithm.accumulate("@background", new_background);
							System.out.println("new_background: "  + new_background);
						}
						
//						replaceImg(graphicsAlgorithm, isDeleted);
					}
//					String conflict_key = conflictInfo.optJSONArray("conflict_key").getString(0);
//					String alternative_text = conflictInfo.optString(conflict_key);
//					JSONObject alternative = new JSONObject();
//					alternative.put("@key", ValueUtil.ALTERNATIVE_TEXT);
//					alternative.put("@value", alternative_text);
//					properties.put(alternative);
					
					// 将贴图换成实线红框
//					JSONObject graphicsAlgorithm = node.optJSONObject("graphicsAlgorithm");
//					replaceImg(graphicsAlgorithm, isDeleted);
				}
			}
		}
		if(connections != null){
			if (connections instanceof JSONObject) { // 单个连线
				JSONObject connection = (JSONObject) connections;
				removeExtraInfoOfConnections(connection);
			} else { // 连线数组
				JSONArray connectionArr = (JSONArray) connections;
				for (int i = 0; i < connectionArr.length(); i++) {
					removeExtraInfoOfConnections(connectionArr.getJSONObject(i));
				}
			}
		}
//		if (connections instanceof JSONObject) { // 单个连线
//			JSONObject connection = (JSONObject) connections;
//			removeExtraInfoOfConnections(connection);
//		} else { // 连线数组
//			JSONArray connectionArr = (JSONArray) connections;
//			for (int i = 0; i < connectionArr.length(); i++) {
//				removeExtraInfoOfConnections(connectionArr.getJSONObject(i));
//			}
//		}
		if (diagram.has("childrenlist")) {
			diagram.remove("childrenlist");
		}

		// 生成最后的xml串
		xmi.remove("Ztag");
		String xml = XML.toString(midfile);
		int spliter = xml.lastIndexOf("</xmi:XMI>");
		StringBuilder result = new StringBuilder();
		result.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		result.append(xml.substring(0, spliter));
		result.append(boXMLStr);
		result.append("</xmi:XMI>");
		return result.toString();
	}
	
	// TODO 也许需要考虑环的情况？增加visit访问数组
	/**
	 * 深度优先遍历所有节点，起点是入度为0的节点。目的是生成BusinessObjects和节点内的link
	 * @param node 该节点在allNodeList中的下标
	 * @param tagName 该节点的BusinessObject名称
	 * @param layer 该节点的层级信息，以/分隔
	 * @return 返回这个节点层级的BusinessObject信息，以xml格式输出
	 */
	public static String dfs(int node, String tagName, String layer) {
		StringBuilder sb = new StringBuilder();
		// 处理tag头
		System.out.println("layer22222222222222222222222222222222222: " + layer);
		if (!layer.contains("/")) { // 不含有/说明是根节点，需要加上namespace
			sb.append("<");
			sb.append(namespace);
			System.out.println("namespace: " + namespace);
			
			//(shangmengqi add)
			if( "StructureView".equals(namespace)){
				sb.append(":");
				sb.append(tagName);
				System.out.println("tagName: " + tagName);
				sb.append(" name=\"new");
				sb.append(tagName);
				sb.append("\">");
			}else if ("usecase".equals(namespace)){
				sb.append(":");
				sb.append(tagName);
				System.out.println("tagName: " + tagName);
				sb.append(" name=\"new");
				sb.append(tagName);
				sb.append("\">");
			}else
				{
					sb.append(":");
					sb.append(tagName + "Module");
					System.out.println("tagName: " + tagName);				
//					sb.append(" name=\"");
//					sb.append(tagName);
					sb.append(">");
//					if(tagName != "HorizontalLine"){
//						sb.append(" textContent=\"content1"); //需要获取到该节点的text值
//						sb.append("\">");
//					}else {
//						sb.append("\">");
//					}				
				}
//			sb.append(":");
//			sb.append(tagName);
//			System.out.println("tagName: " + tagName);
//			sb.append(" name=\"new");
//			sb.append(tagName);
//			sb.append("\">");
		} else {
			sb.append("<");
			sb.append(tagName.toLowerCase());
			System.out.println("tagName.toLowerCase(): " + tagName.toLowerCase());
			sb.append(" name=\"new");
			sb.append(tagName);
			sb.append("\">");
		}
		
		// 在该node中添加link
		JSONObject link = allNodeList.get(node).optJSONObject("link");
		System.out.println("link: " + link.toString());
		link.remove("@businessObjects");
		link.accumulate("@businessObjects", generateLink(layer));
		System.out.println("generateLink(layer): " + generateLink(layer)); // /1
		
		// 处理与其相连的节点（终点）
		List<Integer> destinationNode = new ArrayList<Integer>();
		for (int i = 0; i < connectionList.size(); i++) { // 获取当前节点的所有终点
			if (connectionList.get(i).start == node) { // 起点为当前节点
				destinationNode.add(Integer.valueOf(connectionList.get(i).end));
//				System.out.println("destinationNodewwwwwwwwwwwwwwwwwwwwwwwww: " + destinationNode.get(i).toString());
			}
		}
		// TODO 子节点是否需要考虑？？
		// 处理其终点
		Map<String, Integer> boNameCountMap = new HashMap<String, Integer>();
		for (int i = 0; i < destinationNode.size(); i++) {
			int count = 1;
			int index = destinationNode.get(i);
			String tag = allNodeList.get(index).optJSONObject("link").optString("@businessObjects");
			
			if (boNameCountMap.containsKey(tag)) {
				count = boNameCountMap.get(tag);
				boNameCountMap.remove(tag);
				boNameCountMap.put(tag, Integer.valueOf(count));
			} else {
				boNameCountMap.put(tag, Integer.valueOf(1));
			}
			System.out.println("index: " + index);
			System.out.println("tag: " + tag);
//			System.out.println(layer+"/@"+tag.toLowerCase()+"."+(count-1));
			System.out.println(layer+"/@"+tag.toLowerCase()+"."+(count-1));
			sb.append(dfs(index, tag, layer+"/@"+tag.toLowerCase()+"."+(count-1)));
		}
		
		// 处理close tag
		if (!layer.contains("/")) { // 不含有/说明是根节点，需要加上namespace
			sb.append("</");
			sb.append(namespace);
			sb.append(":");
			
			//(shangmengqi add)
			if("StructureView".equals(namespace)){
				sb.append(tagName);
				sb.append(">");
			}else if("usecase".equals(namespace)){
				sb.append(tagName);
				sb.append(">");
			}else{
				sb.append(tagName + "Module");
				sb.append(">");
				}
//			sb.append(tagName);
//			sb.append(">");
		} else {
			sb.append("</");
			sb.append(tagName.toLowerCase());
			System.out.println("tagName.toLowerCase(): " + tagName.toLowerCase());
			sb.append(">");
		}
		
		System.out.println("sb wwwwwwwwwwwwwwwwwwwwwwww: " + sb.toString());
		return sb.toString();
	}
	
	public static String dfs1(int index, String tagName, int num){
		StringBuilder sb = new StringBuilder();
		// 处理tag头
		sb.append("<");
		sb.append(namespace);
		sb.append(":");
		if("HorizontalLine".equals(tagName)){
			sb.append(tagName + "Moudle");
			sb.append(">");
		}else if("Title".equals(tagName)){
			sb.append(tagName + "Moudle");
			sb.append(">");
		}else {
			sb.append(tagName + "Module");
			sb.append(">");
		}
		
		
		// 在该node中添加link
		JSONObject link = allNodeList.get(index).optJSONObject("link");
		System.out.println("link: " + link.toString());			
		link.remove("@businessObjects");
		link.accumulate("@businessObjects", "/"+num);				
		System.out.println("tagNamezzzzzzzzzzzzzzzzzzzzzzzz: " + tagName);
		System.out.println("linkzzzzzzzzzzzzzzzzzzzzzzzz: " + allNodeList.get(index).optJSONObject("link"));
		
		// 处理close tag
		sb.append("</");
		sb.append(namespace);
		sb.append(":");
		if("HorizontalLine".equals(tagName)){
			sb.append(tagName + "Moudle");
			sb.append(">");
		}else if("Title".equals(tagName)){
			sb.append(tagName + "Moudle");
			sb.append(">");
		}else {
			sb.append(tagName + "Module");
			sb.append(">");
		}
		
		
		System.out.println("sb wwwwwwwwwwwwwwwwwwwwwwww: " + sb.toString());
		return sb.toString();
	}
	
	/**
	 * 根据节点的层级信息，生成link值
	 * @param layer 节点的层级信息，以/分隔
	 * @return
	 */
	public static String generateLink(String layer) {
		return "/"+layer;
	}
	
	/**
	 * 删除连线中多余的信息
	 * @param connection
	 */
	public static void removeExtraInfoOfConnections(JSONObject connection) {
		// 删除index
		if (connection.has("@index")) {
			connection.remove("@index");
		}

		// 删除conn_id
		if (connection.has("@conn_id")) {
			connection.remove("@conn_id");
		}
	}
	
	/**
	 * 对节点的处理，包括：
	 * 1.将ext中的text和polyline放回children
	 * 2.添加该节点的PictogramLinks
	 * 3.修改该节点的anchors中outgoingConnections和incomingConnections为下标索引
	 * @param node 节点
	 * @param layer 层级信息
	 * @param connections 连线
	 */
	public static void processNode(JSONObject node, String layer, Object connections) {
		// 需要判断这个节点是否是一个node，或者是一个text或polyline
		if (!node.has("@shape_id")) {
			return;
		} else {
			String id = node.optString("@shape_id");
			allNodeMap.put(id, allNodeList.size());
		}
		allNodeList.add(node);
		
		// 将ext中的text和polyline放入子children中
		if (node.has("ext")) {
			JSONObject ext = node.optJSONObject("ext");
			JSONArray texts = ext.optJSONArray("text");
			for (int i = 0; i < texts.length(); i++) {
				node.accumulate("children", texts.getJSONObject(i));
			}
			
			JSONArray polylines = ext.optJSONArray("polyline");
			for (int i = 0; i < polylines.length(); i++) {
				node.accumulate("children", polylines.getJSONObject(i));
			}
		}
		
		// 在PictogramLinks中添加这个节点的层级信息
		pictogramLinks.append(generatePictogramLink(layer));
		pictogramLinks.append(" ");
		
		// 将该节点的孩子压入队列
		if (node.has(ValueUtil.CHILDREN)) {
			LayeredNode lnode = new LayeredNode(node.opt(ValueUtil.CHILDREN), layer);
			queue.add(lnode);
		}
		
		// 在当前节点中添加@layer属性
		node.accumulate("@layer", layer);
		
		// 对anchors中的outgoingConnections和incomingConnections进行处理
		if (node.has("anchors")) {
			JSONObject anchors = node.optJSONObject("anchors");
			
			// 处理outgoingConnections
			if (anchors.has("@outgoingConnections")) {
				String out = anchors.optString("@outgoingConnections");
				if (out.length() != 0) {
					String[] each = out.split(" ");
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < each.length; i++) {
						JSONObject connection = connectionMap.get(each[i]);
						sb.append("/0/@connections.");
						sb.append(connection.optString("@index"));
						sb.append(" ");
					}
					anchors.remove("@outgoingConnections");
					anchors.accumulate("@outgoingConnections", sb.toString());
				} else {
					anchors.remove("@outgoingConnections");;
				}
			}
			
			// 处理incomingConnections
			if (anchors.has("@incomingConnections")) {
				String in = anchors.optString("@incomingConnections");
				if (in.length() != 0) {
					String[] each = in.split(" ") ;
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < each.length; i++) {
						JSONObject connection = connectionMap.get(each[i]);
						sb.append("/0/@connections.");
						sb.append(connection.optString("@index"));
						sb.append(" ");
					}
					anchors.remove("@incomingConnections");
					anchors.accumulate("@incomingConnections", sb.toString());
				} else {
					anchors.remove("@incomingConnections");
					LayeredBONode lbNode = new LayeredBONode(allNodeList.size()-1, null);
					layeredBOList.add(lbNode);
				}
			}
		}
	}
	
	/**
	 * 根据layer信息生成PictogramLinks的字符串
	 * @param layer 节点的层级信息
	 * @return 类似于/0/@children.0/@link的字符串
	 */
	public static String generatePictogramLink(String layer) {
		String[] layers = layer.split("/");
		StringBuilder sb = new StringBuilder();
		sb.append("/0");
		for (int i = 1; i < layers.length; i++) {
			sb.append("/@children.");
			sb.append(layers[i]);
		}
		sb.append("/@link");
		
		return sb.toString();
	}
	
	/**
	 * 对连线的处理，主要包括修改start和end为下标索引串
	 * @param connection
	 */
	public static void processConnection(JSONObject connection) {
		// 处理start
		String startID = connection.optString("@start");
		int index = (allNodeMap.get(startID)).intValue(); // intValue()方法用来输出int数据
		JSONObject startNode = allNodeList.get(index);
		int start = index;
		String startLayer = generateLayeredInfo(startNode.optString("@layer"));
		connection.remove("@start");
		connection.accumulate("@start", startLayer);
		
		// 处理end
		String endID = connection.optString("@end");
		index = (allNodeMap.get(endID)).intValue();
		JSONObject endNode = allNodeList.get(index);
		int end = index;
		String endLayer = generateLayeredInfo(endNode.optString("@layer"));
		connection.remove("@end");
		connection.accumulate("@end", endLayer);
		
		connectionList.add(new IndexedConnection(start, end));
	}
	
	/**
	 * 根据某个节点的层级信息，生成该节点所对应的索引信息，如/0/@children.2/@anchors.0
	 * @param layer
	 * @return
	 */
	public static String generateLayeredInfo(String layer) {
		String[] layers = layer.split("/");
		StringBuilder sb = new StringBuilder();
		sb.append("/0");
		for (int i = 1; i < layers.length; i++) {
			sb.append("/@children.");
			sb.append(layers[i]);
		}
		sb.append("/@anchors.0");
		
		return sb.toString();
	}
	
	/**
	 * 将节点中的贴图，根据是否删除，替换成为对应的虚线红框或是实线红框
	 * @param graphicsAlgorithm
	 * @param isDeleted
	 */
	public static void replaceImg(JSONObject graphicsAlgorithm, boolean isDeleted) {
		String img_id = graphicsAlgorithm.optString("@id");
		System.out.println("img_id: " + img_id);
		int lastDot = img_id.lastIndexOf(".");
		System.out.println("lastDot: " + lastDot);
		String suffix = img_id.substring(lastDot, img_id.length());
		System.out.println("suffix: " + suffix);
		String new_img_id = "";
		if (isDeleted) {
			new_img_id = img_id.substring(0, lastDot) + suffix + "-delte-red";
			System.out.println("new_img_id: " + new_img_id);
		} else {
			new_img_id = img_id.substring(0, lastDot) + suffix + "-conflict-red";
			System.out.println("new_img_id: " + new_img_id);
		}
		graphicsAlgorithm.remove("@id");
		graphicsAlgorithm.accumulate("@id", new_img_id);
	}
}

class LayeredNode{
	Object childList;
	String layer;
	
	public LayeredNode(Object childList, String layer) {
		this.childList = childList;
		this.layer = layer;
	}
}

class LayeredBONode {
	int index;
	List<LayeredBONode> list;
	
	public LayeredBONode(int index, List<LayeredBONode> list) {
		this.index = index;
		this.list = list;
	}
}

class IndexedConnection {
	int start;
	int end;
	
	public IndexedConnection(int start, int end) {
		this.start = start;
		this.end = end;
	}
}