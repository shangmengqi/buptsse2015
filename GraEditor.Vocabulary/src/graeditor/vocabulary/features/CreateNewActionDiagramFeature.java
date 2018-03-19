package graeditor.vocabulary.features;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.graeditor.vocabulary_model.VocabularyModule;

import graeditor.utils.DiagramUtil;
import midfile.json.graphiti.ToMidFile;

public class CreateNewActionDiagramFeature extends AbstractCustomFeature{

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
										}
									}
								}
							}
						}
					System.out.println(ret);
					
					
					
					}
				}
        	}
        }
        
        
        
        
        
        
        /**
         * 将当前图表文件转换为中间文件格式
         */
        
//        String currentDiagramName = currentDiagram.getName();
//        String uriString = currentDiagram.eResource().getURI().toString().substring(18);
//		String currentDiagramPath = "E:/Git/buptsse2015/runtime-EclipseApplication" + uriString;
//		System.out.println("currentDiagramPath: " + currentDiagramPath);		
//		String vocabularyDiagramStr = ToMidFile.toMidFile(currentDiagramPath);
////        System.out.println("vocabularyDiagramStr" + vocabularyDiagramStr);
//        
//        
//        Gson gson = new Gson();
//		JsonParser parse =new JsonParser();
//		JsonObject vocabularyDiagramObj= (JsonObject) parse.parse(vocabularyDiagramStr);
//        
//		JsonArray connectionArray = ((JsonObject)((JsonObject)vocabularyDiagramObj.get("description")).get("-diagram")).get("connections").getAsJsonArray();
//		System.out.println(connectionArray.toString());
//		
//		//遍历连线，找出含有当前选择节点id的连线,找出跟该节点相关联的叶子节点leafNodeIdStr
//		for (int i = 0; i < connectionArray.size(); i++) {
//			String connectionStr = connectionArray.get(i).getAsJsonObject().get("@conn_id").toString();
//			if (connectionStr.contains(currentShap_id)) {
//				System.out.println("connectionStr: " + connectionStr);
//				//拿取连线的终止节点，即当前节点的叶子节点
//				leafNodeAllIdStr = connectionArray.get(i).getAsJsonObject().get("@end").toString();
//				if (!leafNodeAllIdStr.contains(currentShap_id)) {
//					String leadNodeIdStr = leafNodeAllIdStr;
//					System.out.println("leafNodeIdStr: " + leadNodeIdStr);
//					
//					//在当前图表文件中找出这两个叶子节点、以及对应的编号
//					//遍历该图表文件的节点
//					JsonArray nodeArray = ((JsonObject)((JsonObject)vocabularyDiagramObj.get("description")).get("-diagram")).get("node").getAsJsonArray();
//					for (int j = 0; j < nodeArray.size(); j++) {
//						String nodeStringId = nodeArray.get(j).getAsJsonObject().get("@shape_id").toString();
//						if (nodeStringId.contains(leadNodeIdStr)) {
//							//
//							System.out.println("nodeStringId: " + nodeStringId);
//						}
//					}
//				}				
//			}			
//		}

		
		
		
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
	


}
