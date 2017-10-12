package graeditor.usecase.features;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMultiDeleteInfo;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.mm.pictograms.CompositeConnection;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;


import graeditor.utils.DiagramUtil;
import graeditor.utils.ValueUtil;

public class DeleteFeatureNotify extends DefaultDeleteFeature{

	public DeleteFeatureNotify(IFeatureProvider fp) {
		super(fp);
	}
	
	
	@Override
	public void delete(IDeleteContext context) {
		boolean flag = false;
		/*
		 * ��������ͼ���ļ�
		 * �ҳ�����link��ͼ���ļ�
		 * ���������ǵ�ǰ�ڵ�
		 * ������ʾ��ѯ�ʸýڵ����XXͼ���Ƿ����ɾ��
		 * �ǣ�ɾ���ýڵ㣬��ɾ����֮�����Ľڵ㣻�񣺲������κβ���
		 */
		System.out.println("��ʼɾ��");
		
		final Diagram diagram = getDiagram();
		PictogramElement element = context.getPictogramElement();
		
		System.out.println("element: " + element.getLink());
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
									String messageA = "This node associate" + "\"" + d.getName() + ".diagram\"" + ",are you want to continue delete��";
		//							String messageB = "Version B has Text \"" + newText +"\"\n";
		//							String messageC = "Which to keep?";
									MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
											ValueUtil.TITLE_CONFLICT_DELETE, null, messageA, MessageDialog.ERROR, 
											new String[] { "OK", "CANCLE" }, 0);
									int s = dialog.open();
									
									if (s == 0) { // �滻����
										//����Դ�뷽ʽɾ���ýڵ㣨������ʾ����ʾ�ýڵ����֮������ͼ���ļ����ᱻɾ�����Ƿ������
										System.out.println("����ɾ���ýڵ�,ͬʱɾ����֮����ͼ���ļ�");
										deleteAssociateDiagram(d);
										deleteTheElement(context);
										
										
									} else if (s == 1){	
										System.out.println("����ɾ��,�������κβ���");
																	
										}
									}else {
										//����Դ��ɾ����������ɾ����������ʾ��ɾ���ýڵ㣬ͬʱɾ����ýڵ������������
										System.out.println("��ͨɾ��");
										deleteTheElement(context);
										
									}
								}
							}
						}
					}
				}
//																										
			}			
		}
//		
	}
	
	/*
	 * ��ͨɾ���ڵ�Դ��
	 */
	public void deleteTheElement(IDeleteContext context){
		setDoneChanges(false);

		IMultiDeleteInfo multiDeleteInfo = context.getMultiDeleteInfo();
		if (multiDeleteInfo != null && multiDeleteInfo.isDeleteCanceled()) {
			return;
		}
		PictogramElement pe = context.getPictogramElement();
		Object[] businessObjectsForPictogramElement = getAllBusinessObjectsForPictogramElement(pe);
		if (businessObjectsForPictogramElement != null && businessObjectsForPictogramElement.length > 0) {
			if (multiDeleteInfo == null) {
				if (!getUserDecision(context)) {
					return;
				}
			} else {
				if (multiDeleteInfo.isShowDialog()) {
					boolean okPressed = getUserDecision(context);
					if (okPressed) {
						// don't show further dialogs
						multiDeleteInfo.setShowDialog(false);
					} else {
						multiDeleteInfo.setDeleteCanceled(true);
						return;
					}
				}
			}
		}

		preDelete(context);
		if (isDeleteAbort()) {
			throw new OperationCanceledException();
		}
		if (pe instanceof CompositeConnection) {
			// Find all domain objects for the children connections of the
			// composite connection...
			List<Object> compositeChildConnectionsBOs = collectCompositeConnectionsBOs((CompositeConnection) pe);
			// ... and add them to the list of BOs to delete (no duplicates)
			for (Object object : businessObjectsForPictogramElement) {
				if (!compositeChildConnectionsBOs.contains(object)) {
					compositeChildConnectionsBOs.add(object);
				}
			}
			// Update BOs to delete
			businessObjectsForPictogramElement = compositeChildConnectionsBOs
					.toArray(new Object[compositeChildConnectionsBOs.size()]);
		}
		IRemoveContext rc = new RemoveContext(pe);
		IFeatureProvider featureProvider = getFeatureProvider();
		IRemoveFeature removeFeature = featureProvider.getRemoveFeature(rc);
		if (removeFeature != null) {
			removeFeature.remove(rc);
			// Bug 347421: Set hasDoneChanges flag only after first modification
			setDoneChanges(true);
		}

		deleteBusinessObjects(businessObjectsForPictogramElement);

		postDelete(context);
	}
	
	
	private List<Object> collectCompositeConnectionsBOs(CompositeConnection composite) {
		List<Object> result = new ArrayList<Object>();
		for (Connection childConnection : composite.getChildren()) {
			Object[] allBusinessObjectsForChildConnection = getAllBusinessObjectsForPictogramElement(childConnection);
			for (Object object : allBusinessObjectsForChildConnection) {
				if (!result.contains(object)) {
					result.add(object);
				}
			}
		}
		return result;
	}
	
	public void deleteAssociateDiagram(Diagram associateDiagram){
		System.out.println("associateDiagram.eResource(): " + associateDiagram.eResource().getURI().toString());
		MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				ValueUtil.ASSOCIATE_DIAGRAM_DELETE, null, "Are you sure want to delete the associate diagram?", MessageDialog.ERROR, 
				new String[] { "OK", "CANCLE" }, 0);
		int s = dialog.open();
		if (s == 0) {
//			List<IFile> files = getDiagramFiles(DiagramUtil.getCurrentProject());
//			for (int i = files.size() - 1; i >= 0; i--) {
//				System.out.println("files.get(i)" + files.get(i).toString());
//				try {
//					files.get(i).delete(true, null);
//				} catch (CoreException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			String uriString = associateDiagram.eResource().getURI().toString();
			String[] pathSuStrings = uriString.split("/");
			String pathSub = uriString.substring(18, uriString.length());
			System.out.println("pathSub: " + pathSub);
			String path = "E:/Git/buptsse2015/runtime-EclipseApplication" + pathSub;
			File file = new File(path);
			if (file.isFile() && file.exists()) {
				file.delete();
			}
		}else if (s == 1) {
			
		}		
	}
	
	/**
	 * �ݹ����������.diagrams�ļ�
	 * @param folder
	 * @return
	 */
	private List<IFile> getDiagramFiles(IContainer folder) { // folder = ProjectUtil.getCurrentProject()
		final List<IFile> ret = new ArrayList<IFile>();
		try {
			final IResource[] members = folder.members(); // ��ø���Ŀ�����е��ļ��С��ļ�
			for (final IResource resource : members) {
				if (resource instanceof IContainer) {
					System.out.println("111: " + resource);
					ret.addAll(getDiagramFiles((IContainer) resource));					
				} else if (resource instanceof IFile) {
					System.out.println("222: " + resource);
					final IFile file = (IFile) resource;
					if (file.getName().endsWith(".diagram")) { //$NON-NLS-1$
						ret.add(file);
						System.out.println("444: " + ret);
					}
				}
			}
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return ret;
	}

	

}
