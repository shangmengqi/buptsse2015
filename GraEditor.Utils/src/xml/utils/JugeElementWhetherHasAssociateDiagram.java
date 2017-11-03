//package xml.utils;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.HashSet;
//
//import org.eclipse.core.resources.IProject;
//import org.eclipse.core.resources.IResource;
//import org.eclipse.core.resources.ResourcesPlugin;
//import org.eclipse.emf.common.util.URI;
//import org.eclipse.emf.ecore.resource.Resource;
//import org.eclipse.emf.ecore.util.EcoreUtil;
//import org.eclipse.graphiti.features.IFeatureProvider;
//import org.eclipse.graphiti.mm.pictograms.Diagram;
//import org.eclipse.graphiti.mm.pictograms.PictogramElement;
//import org.eclipse.graphiti.ui.editor.DiagramEditor;
//import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;
//import org.eclipse.graphiti.ui.services.GraphitiUi;
//import org.eclipse.jface.viewers.IStructuredContentProvider;
//import org.eclipse.ui.PlatformUI;
//import org.eclipse.ui.dialogs.ListDialog;
//
//import graeditor.utils.DiagramUtil;
//
//public class JugeElementWhetherHasAssociateDiagram {
//	
//	private IStructuredContentProvider fContentProvider;
//	private static IFeatureProvider fp;
//	
//	protected static Collection<Diagram> getDiagrams() {
//		Collection<Diagram> result = Collections.emptyList();
//		Resource resource = getDiagram().eResource();
//		URI uri = resource.getURI();
//		URI uriTrimmed = uri.trimFragment();
//		if (uriTrimmed.isPlatformResource()) {
//			String platformString = uriTrimmed.toPlatformString(true);
//			IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
//			if (fileResource != null) {
//				IProject project = fileResource.getProject();
//				result = DiagramUtil.getDiagrams(project);
//			}
//		}
//		return result;
//	}
//	
//	protected static Diagram getDiagram() {
//		return getFeatureProvider().getDiagramTypeProvider().getDiagram();
//	}
//	
//	public static IFeatureProvider getFeatureProvider() {
//		return fp;
//	}
//	
//	public static Collection<Diagram> getLinkedDiagrams(PictogramElement pe) {
//
//		final Collection<Diagram> ret = new HashSet<Diagram>();
//
////		final Object[] businessObjectsForPictogramElement = getAllBusinessObjectsForPictogramElement(pe);
//
//		final Collection<Diagram> allDiagrams = getDiagrams();
//		for (final Diagram d : allDiagrams) {
//			final Diagram currentDiagram = getDiagram();//currentDiagramΪ��ǰҪ������ת��ͼ��
//			if (!EcoreUtil.equals(currentDiagram, d)) { // always filter out the
//														// current
//				
//				d.getName();
//				System.out.println("d.getName: " + d.getName());				
//										
//					final Object[] businessObjectsForDiagram = getAllBusinessObjectsForPictogramElement(d);
//					System.out.println("businessObjectsForDiagram: " + businessObjectsForDiagram);
//
//					for (int i = 0; i < businessObjectsForDiagram.length; i++) {
//						final Object diagramBo = businessObjectsForDiagram[i];
//						System.out.println("diagramBo: " + diagramBo);
//					
//						//�ַ����Ĳ��
//						String string = diagramBo.toString();
//						System.out.println("diagramBoString: " + string);
//
//						String[] array = new String[20];
//						array = string.split("/");
//						if (array.length > 2) {
//							String s1 = array[array.length-1];
//							String s2 = array[array.length-2];
//							System.out.println(s1);
//							System.out.println(s2);
//							
//							int diagramObj = Integer.parseInt(s1.substring(0, s1.length()-1)) ;
//							String diagramString = s2.substring(0, s2.length()-9);
//							System.out.println("diagramObj : " + diagramObj);
//							System.out.println("diagramString : " + diagramString);
//							
//							
//							//DrillDown���߼�ʵ�֣������и���ǰͼ���Ԫ����ȵ�ͼ����ӵ�������
//							if (currentDiagram.getName().equals(diagramString)) {
//								for (int j = 0; j < currentDiagram.getChildren().size(); j++) {
//									if (currentDiagram.getChildren().get(j).equals(pe)) {
//										int currentObj = j + 1;
//										System.out.println("currentBObject : " + currentObj);
//										if (diagramObj == currentObj) {
//											ret.add(d);
//										}
//									}
//								}
//							}
//						
//						}
//					}
//					
//				}						
//			}
//		return ret;
//	}
//	
//	protected static Object[] getAllBusinessObjectsForPictogramElement(PictogramElement pe) {
//		return getFeatureProvider().getAllBusinessObjectsForPictogramElement(pe);
//	}
//	
//	
//	
//	protected void openDiagramEditor(Diagram diagram) {
//		// Found a diagram to open
//		String diagramTypeProviderId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagram.getDiagramTypeId());
//		GraphitiUiInternal.getWorkbenchService().openDiagramEditor(diagram, diagramTypeProviderId,
//				getDiagramEditorId(diagram));
//	}
//	
//	protected String getDiagramEditorId(Diagram diagram) {
//		return DiagramEditor.DIAGRAM_EDITOR_ID;
//	}
//	
//    public void setContentProvider(IStructuredContentProvider sp) {
//        fContentProvider = sp;
//    }
//
//}
