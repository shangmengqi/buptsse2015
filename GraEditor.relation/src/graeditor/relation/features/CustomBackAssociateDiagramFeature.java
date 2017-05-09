package graeditor.relation.features;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;
import org.eclipse.graphiti.ui.services.GraphitiUi;

import graeditor.utils.DiagramUtil;

public class CustomBackAssociateDiagramFeature extends AbstractCustomFeature{

	public CustomBackAssociateDiagramFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public String getName() {
		return "Back associate diagram";
	}
	
	@Override
    public String getDescription() {
        return "Back associate diagram";
    }
	
	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		String diagramString=null;
		Diagram currentDiagram = getDiagram();
		System.out.println("currentDiagram: " + currentDiagram);

		if (currentDiagram.getLink() != null) {
			EList<EObject> eList = currentDiagram.getLink().getBusinessObjects();
			for (int i = 0; i < eList.size(); i++) {
				System.out.println("eListResource: " + eList.get(i));
				
				//�ַ����Ĳ��
				String string = eList.get(i).toString();
				String[] array = new String[20];
				array = string.split("/");
				if (array.length > 2) {
					String s2 = array[array.length-2];
					System.out.println(s2);
					diagramString = s2.substring(0, s2.length()-9);
					System.out.println("diagramString : " + diagramString);
					
//					openDiagramEditor(diagramString);
				}
			}
		}
		
		final Collection<Diagram> allDiagrams = getDiagrams();
		
		for (final Diagram d : allDiagrams) {
			if (d.getName().equals(diagramString)) {
				DiagramUtil.openDiagramEditor(d);
			}
		}
		
//		for (final Diagram d : allDiagrams) {
//			DiagramUtil.openDiagramEditor(d);
//			break;
//		}
		
	}
		
	protected Collection<Diagram> getDiagrams() {
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
