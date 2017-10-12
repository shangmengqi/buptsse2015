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
		String newText = JOptionPane.showInputDialog(null,"New text��\n",oldText);
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
		System.out.println("�ýڵ㷢���޸�");		
		/*
		 * �����ýڵ�������Ŀ������ͼ���ļ�,����ͼ���ļ��б�
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
//		final PictogramElement pe = context.getPictogramElements()[0]; //��ȡ��ǰ��ѡ���Ԫ��
		
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
					
					//�ַ����Ĳ��
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
							
							// ���쵯����ʾ�ĶԻ�����ʾ�û�ѡ��ɾ������ڵ�����Ǳ�����ǰ״̬
							String messageA = "�ýڵ������" + "\"" + d.getName() + "\"" + "ͼ��,�Ƿ����Ըýڵ���޸ģ�";
//							String messageB = "Version B has Text \"" + newText +"\"\n";
//							String messageC = "Which to keep?";
							MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
									ValueUtil.TITLE_CONFLICT, null, messageA, MessageDialog.ERROR, 
									new String[] { "OK", "CANCLE" }, 0);
							int s = dialog.open();
							
							if (s == 0) { // �滻����
								flag = s;
								System.out.println("�����޸�,�򿪹���ͼ���ļ�");
								openDiagramEditor(d);
							} else if (s == 1){	
								flag = s;
								System.out.println("�����޸�,���򿪹���ͼ���ļ�");
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
		 * �ҳ�����link��ͼ���ļ�,���ص��б�
		 */
		
		
		
		/*
		 * �ҳ�link��ǩ�����˵�ǰ�ڵ��ͼ���ļ���ͼ��,
		 * ������ʾ��ѯ�ʸýڵ���������ͼ���ļ����Ƿ������ǰ����
		 * �ǣ��򿪹�����ͼ���ļ�
		 * �񣺲������κβ���
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
