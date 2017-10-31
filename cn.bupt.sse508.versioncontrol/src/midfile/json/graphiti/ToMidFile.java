package midfile.json.graphiti;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import graeditor.utils.ValueUtil;

public class ToMidFile {
	public static String BUSINESSOBJECT; //businessobject
	public static List<String> CONN_ID_LIST; //conn_id_list
	// 所有的节点列表，仅包括node
	public static List<JSONObject> allNodeList;
	
	/**
	 * 将xml文件转换成为中间文件对象
	 * @param path xml文件的绝对路径
	 * @return 返回中间文件的对象，json格式
	 */
	public static String toMidFile(String path) {
		allNodeList = new ArrayList<JSONObject>();
		
		String xmlSrc = Utils.readFileByLines(path); // xml文件内容
		xmlSrc = insertBOTag(xmlSrc); // 添加tag,获取BUSINESSOBJECT,xmlSrc=添加了tag标签的xml字符串文件
		JSONObject xmlJSONObj = XML.toJSONObject(xmlSrc); // xml串转换成为json对象
		System.out.println("111111111111111111111111111: " + xmlJSONObj.toString());
		
		
		JSONObject xmi = xmlJSONObj.getJSONObject(ValueUtil.XMI); //XMI="xmi:XMI",得到key为xmi:XMI的value值
		JSONObject diagram = xmi.getJSONObject(ValueUtil.DIAGRAM); //DIAGRAM="pi:Diagram",得到key为pi:Diagram的value值
				
		// 以下为获取这张图表的namespace的部分，以@ns为key存入json对象中，便于后续的处理
		{
			Iterator<String> it = null;
			Object obj = xmi.opt(ValueUtil.BO_TAG); //BO_TAG = "Ztag",返回Ztag这个属性
			if (obj instanceof JSONObject) {
				JSONObject ztag = xmi.getJSONObject(ValueUtil.BO_TAG); 
				it = ztag.keys();  //返回画布上的元素
			} else if (obj instanceof JSONArray) {
				JSONArray ztagArray = xmi.getJSONArray(ValueUtil.BO_TAG);
				it = ((JSONObject)(ztagArray.get(0))).keys();
			}
			String namespace = "";
			if (it.hasNext())
				namespace = it.next().toString().split(":")[0]; //namespace=structView(这里以structView为例)
			xmi.accumulate("@ns", namespace);
		}
		
		// 以下为处理这张图表的跳转关系的部分
		{
			Object obj = diagram.opt("link");
			if (obj instanceof JSONArray) {
				// TODO 数组的情况，需要后续补充
			}
			if (null == obj) {
				JSONObject bo = new JSONObject();
				bo.accumulate("@href", "");
				obj = new JSONObject();
				((JSONObject)obj).accumulate("businessObjects", bo);
			}
			diagram.remove("link");
			diagram.append("navi", obj);
		}
		
		CONN_ID_LIST = new ArrayList<String>();
		// 以下为设置connection的start和end的部分，使用节点的id进行标识
		if (diagram.has(ValueUtil.CONNECTIONS)) { //CONNECTIONS = "connections"
			Object obj = diagram.opt(ValueUtil.CONNECTIONS); //获取connection属性
			if (obj instanceof JSONObject) {
				JSONObject connection = (JSONObject) obj;
				processConnections(connection, diagram);
			} else if (obj instanceof JSONArray) {
				JSONArray connectionArray = (JSONArray) obj;
				for (int i = 0; i < connectionArray.length(); i++) {
					JSONObject connection = (JSONObject) connectionArray.get(i);
					processConnections(connection, diagram);
				}
			}
		}
		
		// 以下开始对节点进行处理
		Queue<AttachedNode> queue = new LinkedList<AttachedNode>(); 
		if (diagram.has(ValueUtil.CHILDREN)) { //CHILDREN = "children"
			JSONObject parent = diagram;
			Object obj = diagram.opt(ValueUtil.CHILDREN);
			AttachedNode an = new AttachedNode(obj, parent);
			queue.add(an);
		}
		AttachedNode obj = queue.poll(); //poll()获取并移出元素,diagram下的所有children属性
		while (!queue.isEmpty() || null != obj) {
			if (obj.node instanceof JSONObject) { // 单个对象
				int result = processChildren((JSONObject) obj.node, obj.parent, 0); 
				if (((JSONObject)obj.node).has(ValueUtil.CHILDREN)) {
					Object child = ((JSONObject)obj.node).opt(ValueUtil.CHILDREN);
					AttachedNode an = new AttachedNode(child, (JSONObject)obj.node);
					queue.add(an);
				}
				if (result != -1) { // 需要删除该节点
					obj.parent.remove(ValueUtil.CHILDREN);
				}
				
			} else { // children数组
				JSONArray arr = (JSONArray) obj.node; 
				List<Integer> indexToRemove = new ArrayList<Integer>();
				for (int i = 0; i < arr.length(); i++) {
					int temp = processChildren((JSONObject)arr.get(i), obj.parent, 1); //
					// 用于判断这个节点是否需要被移动至ext中
					if (temp != -1)
						indexToRemove.add(Integer.valueOf(temp));
					
					if (arr.getJSONObject(i).has(ValueUtil.CHILDREN)) { 
						Object child = arr.getJSONObject(i).opt(ValueUtil.CHILDREN);  //拿出数组中的第一个children属性
						AttachedNode an = new AttachedNode(child, arr.getJSONObject(i));
						queue.add(an);
					}
				}
				
				// 执行删除，删除被移动到ext中的非node的children
				for (int i = indexToRemove.size()-1; i > 0; i--) {
					arr.remove(i);
				}
			}
			obj = queue.poll(); //obj = 所有node节点的children
		}
		
		// 对节点添加node属性，即一个node即使没有子node也许要添加一个空的node数组
		for (int i = 0; i < allNodeList.size(); i++) {
			JSONObject child = allNodeList.get(i);
			// 为所有的node创建孩子node数组
			if (!child.has(ValueUtil.CHILDREN)) { // 没有children则创建
				JSONArray nodes = new JSONArray();
				child.put(ValueUtil.CHILDREN, nodes);
			} else if (child.opt(ValueUtil.CHILDREN) instanceof JSONObject) { // 或者只有一个孩子时创建
				JSONObject kid = child.optJSONObject(ValueUtil.CHILDREN);
				child.remove(ValueUtil.CHILDREN);
				JSONArray kids = new JSONArray();
				kids.put(kid);
				child.put(ValueUtil.CHILDREN, kids);
			}
			
			// 为所有node中没有出连线或者入连线的node，添加空的数组
			JSONObject anchor = child.optJSONObject("anchors");
			if (!anchor.has("@outgoingConnections")) { // 没有出连线
				anchor.accumulate("@outgoingConnections", "");
			}
			if (!anchor.has("@incomingConnections")) { // 没有入连线
				anchor.accumulate("@incomingConnections", "");
			}
		}
		
		
		// 以下对字符串进行处理
		String midFileStr = xmlJSONObj.toString(4);
		midFileStr = midFileStr.replace(ValueUtil.XMI, "description");
		midFileStr = midFileStr.replace(ValueUtil.DIAGRAM, "-diagram");
		midFileStr = midFileStr.replace("graphicsAlgorithm", "style");
		midFileStr = midFileStr.replace(ValueUtil.CHILDREN, "node");
		
		return midFileStr;
	}
	
	/**
	 * 处理节点相关的事务，如果需要删除该节点，那么返回该节点的下标，即index；如果不需要删除，那么返回-1
	 * @param child
	 * @param parent
	 * @param index
	 * @return
	 */
	public static int processChildren(JSONObject child, JSONObject parent, int index) {
		// 判断当前这个children是否为一个node
		boolean isNode = isNode(child);
		if (isNode) { // 是node
			allNodeList.add(child);
			
			// 处理id相关
			String id = getIDFromProperties(child.opt(ValueUtil.PROPERTIES), ValueUtil.SHAPE_ID); //id=Page-1497229346326
			System.out.println("id1111111:" + id);
			child.accumulate("@"+ValueUtil.SHAPE_ID, id);
			parent.accumulate("nodelist", id);
			
			// 处理link和businessObject
			// 找到该node对应的BusinessObject名称，将其返回
			// 根据id的前缀去找，因此需要在创建id时使用其BusinessObject名称
			String businessObjectName = id.substring(0, id.indexOf("-"));
			child.getJSONObject(ValueUtil.LINK).remove("@businessObjects");
			child.getJSONObject(ValueUtil.LINK).accumulate("@businessObjects", businessObjectName);
			
			JSONObject anchors = child.optJSONObject("anchors"); //anchors xsi:type="pi:ChopboxAnchor" outgoingConnections="/0/@connections.0 /0/@connections.1"
			// 处理anchors中的outgoingConnections
			if (anchors.has("@outgoingConnections")) {
				String ids = convertConnectionIndexToConnID(anchors.optString("@outgoingConnections")); // outgoingConnections="/0/@connections.0 /0/@connections.1"
				anchors.remove("@outgoingConnections");
				anchors.accumulate("@outgoingConnections", ids);
			}
			// 处理anchors中的incomingConnections
			if (anchors.has("@incomingConnections")) {
				String ids = convertConnectionIndexToConnID(anchors.optString("@incomingConnections"));
				anchors.remove("@incomingConnections");
				anchors.accumulate("@incomingConnections", ids);
			}
			
			// 如果是一个node的话，需要创建一个ext数组
			JSONArray text = new JSONArray();
			JSONArray polyline = new JSONArray();
			JSONObject ext = new JSONObject();
			ext.put("text", text);
			ext.put("polyline", polyline);
			child.accumulate("ext", ext);
			
			index = -1;
		} else { // 不是一个node
			JSONObject ga = child.optJSONObject("graphicsAlgorithm");
			if (ga.optString(ValueUtil.XSI_TYPE).equals("al:Text")) { // 文字
				parent.optJSONObject("ext").accumulate("text", child);
			} else {
				parent.optJSONObject("ext").accumulate("polyline", child);
			}
		}
		
		return index;
	}
	
	public static String convertConnectionIndexToConnID(String conn) { // conn的值为outgoingConnections=/0/@connections.0 /0/@connections.1
		// 可能会有多个值，以空格分隔
		String[] conns = conn.split(" "); // 数组长度为2
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < conns.length; i++) {
			int[] index = parseIndexedTag(conns[i]); // conn[0]的值为outgoingConnections=/0/@connections.0  
			// index数组中最多有两层，因为所有的connections是同级排列的
			sb.append(CONN_ID_LIST.get(index[1]));
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	/**
	 * 用于判断一个children是否为node还是文字、线段等
	 * @param children
	 * @return 是node则返回true，否则返回false
	 */
	public static boolean isNode(JSONObject children) {
		if (children.has(ValueUtil.XSI_TYPE)) { //XSI_TYPE = "@xsi:type"
			if (children.optString(ValueUtil.XSI_TYPE).equals("pi:ContainerShape")) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 用于在xml字符串中添加一个tag，这个tag将BusinessObject包含起来，方便以后的转换。最后转换回xml文件时，需要去除这个tag
	 * @param src 原始xml字符串
	 * @return 添加了tag之后的xml字符串
	 */
	public static String insertBOTag(String src) {
		int length = src.length();
		int start = src.lastIndexOf("</pi:Diagram>") + "</pi:Diagram>".length(); //start表示"</pi:Diagram>"最后一个">"后的位置
		int end = length - "</xmi:XMI>".length(); //end=0~</StructureView>
		
		String s1 = src.substring(0, start); //s1=0~</pi:Diagram>
		String s2 = src.substring(start, end); //s2=<StructureView>~</StructureView>
		BUSINESSOBJECT = s2;
		String s3 = src.substring(end, length); //s3=</xmi:XMI>
		
		StringBuilder sb = new StringBuilder();
		sb.append(s1);
		sb.append("<");
		sb.append(ValueUtil.BO_TAG); //BO_TAG="Ztag"
		sb.append(">");
		sb.append(s2);
		sb.append("</");
		sb.append(ValueUtil.BO_TAG);
		sb.append(">");
		sb.append(s3);
		
		return sb.toString();  //sb=添加了tag之后的xml字符串,即添加了<Ztag></Ztag>标签包裹住<StructureView></StructureView>
	}
	
	/**
	 * 用于处理connection中start和end的函数
	 * @param connection
	 * @param diagram
	 */
	public static void processConnections(JSONObject connection, JSONObject diagram) {
		// 处理start
		String startValue = connection.optString("@start"); //startValue = start="/0/@children.0/@anchors.0"
		int[] result = parseIndexedTag(startValue); //result=0
		Object obj = diagram.opt(ValueUtil.CHILDREN); //CHILDREN = "children"
		
		// 找到所对应的那个children
		for (int i = 1; i < result.length; i++) {
			if (obj instanceof JSONObject) { // 单个对象
				// do nothing.
			} else { // 数组
				obj = ((JSONArray) obj).opt(result[i]);
			}
			
			if ((i+1) < result.length) {
				obj = ((JSONObject)obj).opt(ValueUtil.CHILDREN);
			}
		}
		// 获取该children的id
		String startID = getIDFromProperties(((JSONObject)obj).opt(ValueUtil.PROPERTIES), ValueUtil.SHAPE_ID); //PROPERTIES = "properties",SHAPE_ID = "shape_id"
		// 把原有的@start删去，改为使用id
		connection.remove("@start");
		connection.accumulate("@start", startID); //start="/0/@children.0/@anchors.0"改为start="Page-1497229346326"
		
		
		// 下面处理end
		String endValue = connection.optString("@end"); //end="/0/@children.1/@anchors.0"
		result = parseIndexedTag(endValue); //result=1
		obj = diagram.opt(ValueUtil.CHILDREN);
		// 找到所对应的那个children
		for (int i = 1; i < result.length; i++) {
			if (obj instanceof JSONObject) { // 单个对象
				// do nothing.
			} else { // 数组
				obj = ((JSONArray) obj).opt(result[i]);
			}

			if ((i + 1) < result.length) {
				obj = ((JSONObject) obj).opt(ValueUtil.CHILDREN);
			}
		}
		// 获取该children的id
		String endID = getIDFromProperties(((JSONObject) obj).opt(ValueUtil.PROPERTIES), ValueUtil.SHAPE_ID);
		// 把原有的@end删去，改为使用id
		connection.remove("@end");
		connection.accumulate("@end", endID); //end="/0/@children.1/@anchors.0"改为end="PageGroup-1497229350545"
		
		// 获取connection的id，存入CONN_ID_LIST中
		// connection的id是start和end的组合
		String conn_id = startID + "#" + endID;
		CONN_ID_LIST.add(conn_id);
		// 将connection的id存入属性中
		connection.accumulate("@conn_id", conn_id);
	}
	
	/**
	 * 用于处理connections中的start、以及anchors中的outgoingConnection和incomingConnection，如/0/@children.0/@anchors.0的数据
	 * @param src 需要进行处理的字符串
	 * @return 分段之后的编号，以数组形式存储，connection中最后的anchors会被丢弃
	 */
	public static int[] parseIndexedTag(String src) { //src 的值为 start="/0/@children.0/@anchors.0"
		int[] result = null;
		String[] parsed = src.split("/"); //parsed的值为 parsed[0]=start=", parsed[1]=0, parsed[2]=@children.0, parsed[3]=@anchors.0"
		if (src.contains("anchor")) { // 说明是start/end，需要抛弃最后一个
			result = new int[parsed.length - 2]; //数组长度为2
		} else { // outgoingConnection/incomingConnection
			result = new int[parsed.length - 1]; //数组长度为2
		}
		
		result[0] = 0;
		for (int i = 1; i < result.length; i++) {
			String num = parsed[i+1].substring(parsed[i+1].length()-1); //parse[2] num=0
			result[i] = Integer.parseInt(num);
		}
		
		return result;
	}
	
	/**
	 * 从properties中获取id，需要传入properties数组，id的key，@shape_id或@conn_id
	 * @param properties
	 * @param key
	 * @return
	 */
	public static String getIDFromProperties(Object properties, String key) {
		String id = "no_id";
		if (properties instanceof JSONObject) { // 只有一个property
			if (((JSONObject) properties).has("@key")) {
				if (((JSONObject) properties).optString("@key").equals(key)) {
					id = ((JSONObject) properties).optString("@value");
				}
			}
		} else { // properties数组
			for (int i = 0; i < ((JSONArray)properties).length(); i++) {
				JSONObject property = (JSONObject) ((JSONArray)properties).get(i);
				if (property.has("@key")) {
					if (property.optString("@key").equals(key)) {
						id = property.optString("@value");
					}
				}
			}
		}
		
		return id;
	}
}

class AttachedNode{
	Object node;
	JSONObject parent;
	
	public AttachedNode(Object node, JSONObject parent) {
		this.node = node;
		this.parent = parent;
	}
}
