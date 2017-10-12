package graeditor.usecase.features;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.impl.ImageImpl;
import org.eclipse.graphiti.mm.algorithms.impl.TextImpl;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

import graeditor.utils.DiagramUtil;
import graeditor.utils.NotifyChange;
import graeditor.utils.ValueUtil;

public class CustomChangeTextFeature extends AbstractCustomFeature{
	
	public static int flag;

	public CustomChangeTextFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public String getName() {
		return "Change Text";
	}
	
	@Override
    public String getDescription() {
        return "Change the displaying text of this Element";
    }
	
	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		final Diagram currentDiagram = getDiagram();
//		DiagramUtil.changeText(context, context.getPictogramElements()[0], currentDiagram);
		PictogramElement element = context.getPictogramElements()[0];
		Object obj = context.getInnerGraphicsAlgorithm();
		String oldText = "";
		TextImpl text = null;
		if (obj instanceof ImageImpl) {
			if (element instanceof ContainerShape) {
				ContainerShape cs = (ContainerShape) element;
				Shape shape = cs.getChildren().get(0);
				obj = shape.getGraphicsAlgorithm();
			}
		}
		if (obj instanceof TextImpl) {
			text = (TextImpl)obj;
			oldText = text.getValue();
//			text.setValue(newText);
		}
		String newText = JOptionPane.showInputDialog(null,"New text：\n",oldText);
		if (null == newText) {
			return;
		}
		if(newText != oldText){
			notifyChange(currentDiagram, element);
			if (flag == 0) {
				text.setValue(newText);
			}else if (flag == 1) {
				text.setValue(oldText);
			}
		}
	}
	
	public void notifyChange(Diagram diagram, PictogramElement element){
		System.out.println("该节点发生修改");		
		/*
		 * 遍历该节点所在项目下所有图表文件,返回图表文件列表
		 */
		final Collection<Diagram> ret = new HashSet<Diagram>();
		Collection<Diagram> result = Collections.emptyList();
		Resource resource = diagram.eResource();
		URI uri = resource.getURI();
		URI uriTrimmed = uri.trimFragment();
		if (uriTrimmed.isPlatformResource()) {
			String platformString = uriTrimmed.toPlatformString(true);
			IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (fileResource != null) {
				IProject project = fileResource.getProject();
				System.out.println("project: " + project);
				result = DiagramUtil.getDiagrams(project);
				System.out.println("result: " + result);
			}
		}
		final Collection<Diagram> allDiagrams = result;
//		final PictogramElement pe = context.getPictogramElements()[0]; //获取当前被选择的元素
		
		for (final Diagram d : allDiagrams) {
			String diagramName = diagram.getName();
			if (!EcoreUtil.equals(diagram, d)) { // always filter out the														// current
				System.out.println("d: " + d.getName());
				final Object[] businessObjectsForDiagram = getAllBusinessObjectsForPictogramElement(d); //
				System.out.println("businessObjectsForDiagram: " + businessObjectsForDiagram);
				for (int i = 0; i < businessObjectsForDiagram.length; i++) {
					final Object diagramBo = businessObjectsForDiagram[i]; //diagramBo: org.eclipse.emf.ecore.impl.EObjectImpl@be5379 (eProxyURI: platform:/resource/test/src/relation/struct.diagram#/1)
					System.out.println("diagramBo: " + diagramBo);
									
					String string = diagramBo.toString();
					System.out.println("diagramBoString: " + string);
					
					//字符串的拆分
					String[] array = new String[20];
					array = string.split("/");
					if (array.length > 2) {
						String s1 = array[array.length-1];
						String s2 = array[array.length-2];
						System.out.println(s1);
						System.out.println(s2);
						
						int diagramObj = Integer.parseInt(s1.substring(0, s1.length()-1)) ;
						String diagramString = s2.substring(0, s2.length()-9);
						System.out.println("diagramObj : " + diagramObj);
						System.out.println("diagramString : " + diagramString);
						
						if (diagram.getName().equals(diagramString)) {
							for (int j = 0; j < diagram.getChildren().size(); j++) {
								if (diagram.getChildren().get(j).equals(element)) {
									int currentObj = j + 1;
									System.out.println("currentBObject : " + currentObj);
									if (diagramObj == currentObj) {
							System.out.println("find the link diagram is " + d.getName());
							
							// 构造弹出提示的对话框，提示用户选择删除这个节点或者是保留当前状态
							String messageA = "该节点关联了" + "\"" + d.getName() + "\"" + "图表,是否保留对该节点的修改？";
//							String messageB = "Version B has Text \"" + newText +"\"\n";
//							String messageC = "Which to keep?";
							MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
									ValueUtil.TITLE_CONFLICT, null, messageA, MessageDialog.ERROR, 
									new String[] { "OK", "CANCLE" }, 0);
							int s = dialog.open();
							
							if (s == 0) { // 替换文字
								flag = s;
								System.out.println("继续修改,打开关联图表文件");
								openDiagramEditor(d);
							} else if (s == 1){	
								flag = s;
								System.out.println("放弃修改,不打开关联图表文件");
							}
									}
								}
							}
						}
					}
				}
				ret.add(d);																							
			}			
		}
		System.out.println("ret: " + ret.size());
		
		/*
		 * 找出包含link的图表文件,返回到列表
		 */
		
		
		
		/*
		 * 找出link标签关联了当前节点的图表文件的图表,
		 * 弹出提示框，询问该节点关联了这个图表文件，是否继续当前操作
		 * 是：打开关联的图表文件
		 * 否：不进行任何操作
		 */
		
		
		
	}
	
	public void openDiagramEditor(Diagram diagram) {
		// Found a diagram to open
		String diagramTypeProviderId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagram.getDiagramTypeId());
		GraphitiUiInternal.getWorkbenchService().openDiagramEditor(diagram, diagramTypeProviderId,
				getDiagramEditorId(diagram));
	}
	
	public String getDiagramEditorId(Diagram diagram) {
		return DiagramEditor.DIAGRAM_EDITOR_ID;
	}

}
