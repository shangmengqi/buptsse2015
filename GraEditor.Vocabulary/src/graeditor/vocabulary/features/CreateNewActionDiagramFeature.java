package graeditor.vocabulary.features;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.actions.RetargetAction;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.graeditor.vocabulary_model.VocabularyModule;

import graeditor.utils.DiagramUtil;
import midfile.json.graphiti.FromMidFileAboutCreateActionDiagram;
import midfile.json.graphiti.FromMidFileAboutMerge;
import midfile.json.graphiti.ToMidFile;

public class CreateNewActionDiagramFeature extends AbstractCustomFeature{
	
	public static JsonArray merge_nodeArray = new JsonArray();
	
	public static JsonArray node0Array;
	public static JsonArray node1Array;
	public static JsonArray connection0Array = new JsonArray();
	public static JsonArray connection1Array = new JsonArray();

	public CreateNewActionDiagramFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
    public String getName() {
        return "Create associated action diagram";
    }
 
    @Override
    public String getDescription() {
        return "Create new action Diagram";
    }
    
    @Override
    public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        final PictogramElement pe = context.getPictogramElements()[0]; //获取当前被选择的元素
        VocabularyModule selectModule = (VocabularyModule) getBusinessObjectForPictogramElement(pe);
        if (pes != null && pes.length >= 1) {
        	if (selectModule.getNext() != null) {
        		ret = true;
			}           
        }
        return ret;
    }

	@Override
	public void execute(ICustomContext context) {
		
		node0Array = new JsonArray();
		node1Array = new JsonArray();
				
		String diagram0Str = null;
		String leafNodeAllIdStr = null;
		
		Diagram currentDiagram = getDiagram();
//		currentDiagram.getChildren().size();
//		System.out.println(currentDiagram.getChildren().size());
		
		final PictogramElement pe = context.getPictogramElements()[0]; //获取当前被选择的元素		
		System.out.println("pe: " + pe.toString());	
       
//        String currentShap_id = pe.getProperties().get(0).getValue(); //获取当前节点的id
//        System.out.println("currentShap_id: " + currentShap_id);
        
        //获取选中节点的叶子结点
        VocabularyModule selectModule = (VocabularyModule) getBusinessObjectForPictogramElement(pe);
        EList<VocabularyModule> nextNodeModules = selectModule.getNext();
        for (int a = 0; a < nextNodeModules.size(); a++) {
        	VocabularyModule nextNodeModule = nextNodeModules.get(a);
        	System.out.println("nextNodeModule: " + nextNodeModule.getTextContent());
        	
        	for (int b = 0; b < currentDiagram.getChildren().size(); b++) {
				VocabularyModule childNodeModule = (VocabularyModule) getBusinessObjectForPictogramElement(currentDiagram.getChildren().get(b));
				if (childNodeModule.getTextContent().equals(nextNodeModule.getTextContent())) {
					int leafNodeNum = b + 1;  //获取叶子节点在图表中的对应元素数字
					System.out.println(leafNodeNum);
					
					//循环遍历项目下的图表文件，找出叶子节点对应的活动图
					final Collection<Diagram> ret = new HashSet<Diagram>(); //用来接收找出的活动图
					final Collection<Diagram> allDiagrams = getDiagrams(); //获取项目下的所有图表文件
					System.out.println(allDiagrams);
					
					for (final Diagram d : allDiagrams) {  //遍历每张图表文件
						if (!EcoreUtil.equals(currentDiagram, d)) {
							System.out.println("d: " + d.getName());
							
							final Object[] businessObjectsForDiagram = getAllBusinessObjectsForPictogramElement(d);
							System.out.println("businessObjectsForDiagram: " + businessObjectsForDiagram.toString());
							
							for (int c = 0; c < businessObjectsForDiagram.length; c++) {
								final Object diagramBo = businessObjectsForDiagram[c];
								System.out.println("diagramBo: " + diagramBo);
								
								String string = diagramBo.toString();
								System.out.println("diagramBoString: " + string);

								String[] array = new String[20];
								array = string.split("/");
								if (array.length > 2) {
									String s1 = array[array.length-1];
									String s2 = array[array.length-2];
									System.out.println("s1: " + s1);
									System.out.println("s2: " + s2);
									
									int diagramObjNum = Integer.parseInt(s1.substring(0, s1.length()-1)) ;
									String diagramNameString = s2.substring(0, s2.length()-9);
									System.out.println("diagramObjNum : " + diagramObjNum);
									System.out.println("diagramNameString : " + diagramNameString);
									
									if (currentDiagram.getName().equals(diagramNameString)) { //遍历出的图表文件名和当前的图表文件名一样
										if (leafNodeNum == diagramObjNum) {
											ret.add(d);
											System.out.println("找出的活动图： " + d.getName());
											System.out.println("hahahahahahahahahah： " + d.eResource());
											
											//根据文件的绝对路径读取文件内容并重新存储
											String uriString = d.eResource().getURI().toString().substring(18);
											String dDiagramPath = "E:/Git/buptsse2015/runtime-EclipseApplication" + uriString;
											System.out.println("bbbbbbbbbbbbbb: " + dDiagramPath);
											diagram0Str = readFileByLines(dDiagramPath);
											System.out.println("aaaaaaaaaaaaaaaaaa: " + diagram0Str);
											File file = new File("E:/Git/" + d.getName() + ".diagram"); // 文件名字
											writeToFile(diagram0Str,file);
										}
									}
								}
							}
						}				
					
					}
					
				}
				
        	}
        	
        }
        
        /**
         * 将找出的活动图的图表文件转换为中间文件格式，
         * 依次遍历两个活动图图表文件中的节点、连线元素，将添加的节点记录在描述文件中
         * 新建一张活动图表，用来自动生成上面两张图表的并集
         * 添加某些图形元素，完善图表中的连线信息
         */
        String action1DiagramStr = ToMidFile.toMidFile("E:/Git/action_vocabulary4.diagram");
		String action2DiagramStr = ToMidFile.toMidFile("E:/Git/action_vocabulary5.diagram");
//		System.out.println("action1DiagramStr: " + action1DiagramStr);
		
		//遍历每个活动图中的节点信息
		Gson gson = new Gson();
		JsonParser parse =new JsonParser();
		JsonObject diagram0Obj= (JsonObject) parse.parse(action1DiagramStr);
		JsonObject diagram1Obj= (JsonObject) parse.parse(action2DiagramStr);
		
		connection0Array = ((JsonObject)((JsonObject)diagram0Obj.get("description")).get("-diagram")).get("connections").getAsJsonArray();
		connection1Array = ((JsonObject)((JsonObject)diagram1Obj.get("description")).get("-diagram")).get("connections").getAsJsonArray();
		
		/**
		 * 开始处理节点
		 */
		System.out.println("\n\n---------------------");
		System.out.println("开始处理节点");
		System.out.println("222222222222222222222222222: " + node0Array.size());
		node0Array = ((JsonObject)((JsonObject)diagram0Obj.get("description")).get("-diagram")).get("node").getAsJsonArray();
		node1Array = ((JsonObject)((JsonObject)diagram1Obj.get("description")).get("-diagram")).get("node").getAsJsonArray();
		System.out.println("node0Array: " + node0Array.toString());
		System.out.println("node1Array: " + node1Array.toString());
        
		// 遍历action_vocabulary4(diagram0)中的节点
		for (int i = 0; i < node0Array.size(); i++) {
			System.out.println("111111111111111111111111111111111: " + node0Array.size());
			String node0ModuleStyle = node0Array.get(i).getAsJsonObject().get("link").getAsJsonObject().get("@businessObjects").getAsString();
//			System.out.println("node0ModuleStyle: " + node0ModuleStyle);
			if (node0ModuleStyle.equals("Content")) {
				System.out.println("node0ModuleStyle: " + node0ModuleStyle);
				String node0Text = node0Array.get(i).getAsJsonObject().get("ext").getAsJsonObject().get("text").getAsJsonArray().get(0)
						                     .getAsJsonObject().get("style").getAsJsonObject().get("@value").getAsString();
				System.out.println("node0Text: " + node0Text);
				// 根据node0的text在node1中寻找相同text的节点下标
				int j = findNodeById(node0Text, "diagram0");
				System.out.println("j: " + j);
				
				if (j < 0) {  //该节点在node0中存在，在node1中不存在，说明该节点是存在的分叉节点
					System.out.println("该节点在node0中存在，在node1中不存在，该节点是存在的分叉节点");
					//将该节点的信息记录在描述文件中
					String node0IdStr = node0Array.get(i).getAsJsonObject().get("@shape_id").getAsString();
					System.out.println("node0IdStr: " + node0IdStr);
					Map map = new HashMap();
					map.put("diagram", "action_vocabulary4");
					map.put("shap_id", node0IdStr);
					map.put("text", node0Text);
					map.put("action", "fencha");
					String mapString = gson.toJson(map);
					JsonElement mapElement = parse.parse(mapString);
					merge_nodeArray.add(mapElement);
					System.out.println(merge_nodeArray.toString());
					
					//处理与该节点相关的连线节点信息
					for (int k = 0; k < connection0Array.size(); k++) {
						String conn0_id_strString = connection0Array.get(k).getAsJsonObject().get("@conn_id").getAsString();
						if (conn0_id_strString.contains(node0IdStr)) {
							System.out.println("conn0_id_strString: " + conn0_id_strString);
							//获取该节点的前一个节点id和后一个节点id，并存入描述文件中
							String spildNodeIdString = conn0_id_strString.split("#")[0];
							if (!spildNodeIdString.equals(node0IdStr)) {
								String priviousNodeIdString = spildNodeIdString;
								System.out.println("priviousNodeIdString: " + priviousNodeIdString);
								
								//记录前一个节点信息到描述文件中
								Map map1 = new HashMap();
								map1.put("diagram", "action_vocabulary4");
								map1.put("shap_id", priviousNodeIdString);								
								map1.put("action", "priviousNode");
								String map1String = gson.toJson(map1);
								JsonElement mapElement1 = parse.parse(map1String);
								merge_nodeArray.add(mapElement1);
								System.out.println(merge_nodeArray.toString());
								
							}else {
								String nextNodeIdString = conn0_id_strString.split("#")[1];
								System.out.println("nextNodeIdString: " + nextNodeIdString);
								
								//记录后一个节点信息到描述文件中
								Map map2 = new HashMap();
								map2.put("diagram", "action_vocabulary4");
								map2.put("shap_id", nextNodeIdString);								
								map2.put("action", "nextNode");
								String map2String = gson.toJson(map2);
								JsonElement mapElement2 = parse.parse(map2String);
								merge_nodeArray.add(mapElement2);
								System.out.println(merge_nodeArray.toString());
							}
//							String[] node0SplitStrings = conn0_id_strString.split("#");							
//							for (int l = 0; l < node0SplitStrings.length; l++) {
//								String spildNodeIdString = node0SplitStrings[l];
//								System.out.println("node0SplitStrings: " + node0SplitStrings[l]);
//								if (!spildNodeIdString.equals(node0IdStr)) {
//									
//									System.out.println("关联的节点id： " + spildNodeIdString);
//								}
//							}
						}
					}
				}
			}
		}
		
		//遍历action_vocabulary5（diagram1）中的节点
		System.out.println("\n\n");
		System.out.println("遍历action_vocabulary5（diagram1）中的节点");
		for (int a = 0; a < node1Array.size(); a++) {
			String node1ModuleStyle = node1Array.get(a).getAsJsonObject().get("link").getAsJsonObject().get("@businessObjects").getAsString();
			if (node1ModuleStyle.equals("Content")) {
				String node1Text = node1Array.get(a).getAsJsonObject().get("ext").getAsJsonObject().get("text").getAsJsonArray().get(0)
	                     .getAsJsonObject().get("style").getAsJsonObject().get("@value").getAsString();
				System.out.println("node1Text: " + node1Text);
				// 根据node1的text在node0中寻找相同text的节点下标
				int j = findNodeById(node1Text, "diagram1");
				System.out.println("j: " + j);
				
				if (j < 0) {  //该节点在node1中存在，在node0中不存在，说明该节点是存在的分叉节点
					System.out.println("该节点在node1中存在，在node0中不存在，该节点是存在的分叉节点");
					//将该节点的信息记录在描述文件中,并将该节点添加进node0数组中
					
					String node1IdStr = node1Array.get(a).getAsJsonObject().get("@shape_id").getAsString();
					System.out.println("node1IdStr: " + node1IdStr);
					Map map = new HashMap();
					map.put("diagram", "action_vocabulary5");
					map.put("shap_id", node1IdStr);
					map.put("text", node1Text);
					map.put("action", "fencha");
					String mapString = gson.toJson(map);
					JsonElement mapElement = parse.parse(mapString);
					merge_nodeArray.add(mapElement);
					System.out.println(merge_nodeArray.toString());
					
					//获取与该节点相关联的两条连线信息
					for (int k = 0; k < connection1Array.size(); k++) {
						String conn_id_Str = connection1Array.get(k).getAsJsonObject().get("@conn_id").getAsString();
//						System.out.println("conn_id_Str: " + conn_id_Str);
						if (conn_id_Str.contains(node1IdStr)) {
							System.out.println("与该节点相关联的连线信息： " + conn_id_Str );
							JsonObject conn_add_Object = connection1Array.get(k).getAsJsonObject();
							connection0Array.add(conn_add_Object);
						}
					}
					
					//将该分叉的节点添加进node0数组中
					JsonObject node1FenchaObject = node1Array.get(a).getAsJsonObject();
					node0Array.add(node1FenchaObject);
				}
			}
		}
//		System.out.println("node0Array.size: " + node0Array.size());
//		System.out.println("node1Array.size: " + node1Array.size());
		System.out.println("conn0Array.size: " + connection0Array.size());
		System.out.println("conn1Array.size: " + connection1Array.size());
		
		/**
		 * 修改新添加的节点的连线信息，修改相关节点中的anchor信息
		 */
		//获取diagram0图表的连线
		System.out.println("\n\n---------------------");
		System.out.println("开始处理连线");
		
		String priviouNodeIdString = null; //添加的节点的上一个节点
		String nextNodeIdString = null; //添加的节点的下一个节点
		String addNodeIdString = null; //添加的节点
		String fenchaNodeIdString = null; //原图表中开始分叉的节点（diagram0中的action4）
		
		System.out.println("merge_nodeArray.size: " + merge_nodeArray.size());
		for (int c = 0; c < merge_nodeArray.size(); c++) {
			String nodeTypeString = merge_nodeArray.get(c).getAsJsonObject().get("action").getAsString();
			if (nodeTypeString.equals("priviousNode")) {
				priviouNodeIdString = merge_nodeArray.get(c).getAsJsonObject().get("shap_id").getAsString();
				System.out.println("priviouString: " + priviouNodeIdString);
			}else if (nodeTypeString.equals("nextNode")) {
				nextNodeIdString = merge_nodeArray.get(c).getAsJsonObject().get("shap_id").getAsString();
				System.out.println("nextString: " + nextNodeIdString);
			}else if (merge_nodeArray.get(c).getAsJsonObject().get("diagram").getAsString().equals("action_vocabulary5")) {
				addNodeIdString = merge_nodeArray.get(c).getAsJsonObject().get("shap_id").getAsString();
				System.out.println("addNodeString: " + addNodeIdString);
			}else if (nodeTypeString.equals("fencha") && merge_nodeArray.get(c).getAsJsonObject().get("diagram").getAsString().equals("action_vocabulary4")) {
				fenchaNodeIdString = merge_nodeArray.get(c).getAsJsonObject().get("shap_id").getAsString();
			}
		}
		
		//为新添加的节点生成新的连线信息
		String conn_id_add1String = priviouNodeIdString + "#" + addNodeIdString;
		String conn_id_add2String = addNodeIdString + "#" + nextNodeIdString;
		System.out.println("添加的入连线: " + conn_id_add1String);
		System.out.println("添加的出连线: " + conn_id_add2String);
		
		//遍历图表中的所有连线信息，找出与添加节点相关联的两条链线，并修改连线数组中的属性
		for (int b = 0; b < connection0Array.size(); b++) {
			String conn_id_strString = connection0Array.get(b).getAsJsonObject().get("@conn_id").getAsString();
			
//			System.out.println("输出所有连线信息id： " + conn_id_strString);

			if (conn_id_strString.contains(addNodeIdString)) {
				System.out.println("conn_id_strString: " + conn_id_strString);
				if (conn_id_strString.split("#")[0].toString().equals(addNodeIdString)) {
					System.out.println("该连线是一条出连线");
					connection0Array.get(b).getAsJsonObject().remove("@conn_id"); //删除原有连线中的错误属性信息
					connection0Array.get(b).getAsJsonObject().remove("@start");
					connection0Array.get(b).getAsJsonObject().remove("@end");
					connection0Array.get(b).getAsJsonObject().addProperty("@conn_id", conn_id_add2String);
					connection0Array.get(b).getAsJsonObject().addProperty("@start", addNodeIdString);
					connection0Array.get(b).getAsJsonObject().addProperty("@end", nextNodeIdString);
					System.out.println("输出修改的出连线id： " + connection0Array.get(b).getAsJsonObject().get("@conn_id").getAsString());
				}else if (conn_id_strString.split("#")[1].toString().equals(addNodeIdString)) {
					System.out.println("该连线是一条入连线");
					connection0Array.get(b).getAsJsonObject().remove("@conn_id"); //删除原有连线中的错误属性信息
					connection0Array.get(b).getAsJsonObject().remove("@start");
					connection0Array.get(b).getAsJsonObject().remove("@end");
					connection0Array.get(b).getAsJsonObject().addProperty("@conn_id", conn_id_add1String);
					connection0Array.get(b).getAsJsonObject().addProperty("@start", priviouNodeIdString);
					connection0Array.get(b).getAsJsonObject().addProperty("@end", addNodeIdString);
					System.out.println("输出修改的入连线id： " + connection0Array.get(b).getAsJsonObject().get("@conn_id").getAsString());
				}
//					
				
			}			
		}
		
		//修改新添加节点和与该节点相关联的节点的anchors信息
		for (int e = 0; e < node0Array.size(); e++) {
			if (node0Array.get(e).getAsJsonObject().get("@shape_id").getAsString().equals(addNodeIdString)) {
				//修改新添加的节点的anchors信息
				String anchor_incom = conn_id_add1String;
				String anchor_outgoing = conn_id_add2String;
				node0Array.get(e).getAsJsonObject().get("anchors").getAsJsonObject().remove("@incomingConnections");
				node0Array.get(e).getAsJsonObject().get("anchors").getAsJsonObject().remove("@outgoingConnections");
				node0Array.get(e).getAsJsonObject().get("anchors").getAsJsonObject().addProperty("@incomingConnections", anchor_incom + " ");
				node0Array.get(e).getAsJsonObject().get("anchors").getAsJsonObject().addProperty("@outgoingConnections", anchor_outgoing + " ");
				
				//修改该节点的位置信息
				node0Array.get(e).getAsJsonObject().get("style").getAsJsonObject().remove("@y");
				node0Array.get(e).getAsJsonObject().get("style").getAsJsonObject().remove("@x");
				node0Array.get(e).getAsJsonObject().get("style").getAsJsonObject().addProperty("@y", 413);
				node0Array.get(e).getAsJsonObject().get("style").getAsJsonObject().addProperty("@x", 890);
			}else if (node0Array.get(e).getAsJsonObject().get("@shape_id").getAsString().equals(priviouNodeIdString)) {
				//修改该节点的前一个节点的anchors信息，添加一条出连线
				String anchor_outString = conn_id_add1String;
				String anchor_outgoing_before = node0Array.get(e).getAsJsonObject().get("anchors").getAsJsonObject().get("@outgoingConnections").getAsString();
				String anchor_outgoing_afterString = anchor_outgoing_before + anchor_outString;
				node0Array.get(e).getAsJsonObject().get("anchors").getAsJsonObject().remove("@outgoingConnections");
				node0Array.get(e).getAsJsonObject().get("anchors").getAsJsonObject().addProperty("@outgoingConnections", anchor_outgoing_afterString + " ");
				System.out.println("修改前的anchors信息： " + anchor_outgoing_before);
				System.out.println("修改后的anchors信息： " + anchor_outgoing_afterString);
			}else if (node0Array.get(e).getAsJsonObject().get("@shape_id").getAsString().equals(nextNodeIdString)) {
				//修改该节点的后一个节点的anchors信息
				String anchor_incomString = conn_id_add2String;
				String anchor_incoming_before = node0Array.get(e).getAsJsonObject().get("anchors").getAsJsonObject().get("@incomingConnections").getAsString();
				String anchor_incoming_afterString = anchor_incoming_before + anchor_incomString;
				node0Array.get(e).getAsJsonObject().get("anchors").getAsJsonObject().remove("@incomingConnections");
				node0Array.get(e).getAsJsonObject().get("anchors").getAsJsonObject().addProperty("@incomingConnections", anchor_incoming_afterString + " ");
			}else if (node0Array.get(e).getAsJsonObject().get("@shape_id").getAsString().equals(fenchaNodeIdString)) {
				
			}
		}
		
		System.out.println(diagram0Obj.toString());
		String newActionDiagramXml = FromMidFileAboutCreateActionDiagram.fromMidFileAboutCreateActionDiagram(diagram0Obj.toString());
        
		
		File file = new File("E:/Git/buptsse2015/runtime-EclipseApplication/test/src/newActionDiagram.diagram"); // 文件名字
		writeToFile(newActionDiagramXml, file);
        
        
		
	}
	
	/**
	 * 通过节点id寻找拥有相同节点id的下标
	 * @param id
	 * @param diagram
	 * @return
	 */
	public static int findNodeById(String text, String diagram){
		if (diagram.equals("diagram0")) {
			for (int j = 0; j < node1Array.size(); j++) {
				String node1ModuleStyle = node1Array.get(j).getAsJsonObject().get("link").getAsJsonObject().get("@businessObjects").getAsString();
				if (node1ModuleStyle.equals("Content")) {
					String node1Text = node1Array.get(j).getAsJsonObject().get("ext").getAsJsonObject().get("text").getAsJsonArray().get(0)
		                     .getAsJsonObject().get("style").getAsJsonObject().get("@value").getAsString();
					if (text.equals(node1Text)) {
						return j;
					}
				}
							
			}
		}else {
			for (int j = 0; j < node0Array.size(); j++) {
				String node0ModuleStyle = node0Array.get(j).getAsJsonObject().get("link").getAsJsonObject().get("@businessObjects").getAsString();
//				String node1IdString = node0Array.get(j).getAsJsonObject().get("@shape_id").getAsString();
				if (node0ModuleStyle.equals("Content")) {
					String node0Text = node0Array.get(j).getAsJsonObject().get("ext").getAsJsonObject().get("text").getAsJsonArray().get(0)
		                     .getAsJsonObject().get("style").getAsJsonObject().get("@value").getAsString();
					if (text.equals(node0Text)) {
						return j;
					}
				}
			}
		}
		return -1;		
	}
	
	
	public Collection<Diagram> getDiagrams() {
		Collection<Diagram> result = Collections.emptyList();
		Resource resource = getDiagram().eResource();
		URI uri = resource.getURI();
		URI uriTrimmed = uri.trimFragment();
		if (uriTrimmed.isPlatformResource()) {
			String platformString = uriTrimmed.toPlatformString(true);
			IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (fileResource != null) {
				IProject project = fileResource.getProject();
				result = DiagramUtil.getDiagrams(project);
			}
		}
		return result;//result���ر༭����ͬһ����Ŀ�����е�diagramͼ����Ϣ������ͼ�����ƣ�������Щdiagram����һ��������
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
	
	/**
	 * 以行为单位读取文件，用于读面向行的格式化文件
	 */
	public static String readFileByLines(String filePath) {
		File file = new File(filePath);
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(file));
			String temp = "";
			// 一次读入一行，直到读入null为文件结束
			while ((temp = reader.readLine()) != null) {
				sb.append(temp);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return sb.toString();
	}
	
}
