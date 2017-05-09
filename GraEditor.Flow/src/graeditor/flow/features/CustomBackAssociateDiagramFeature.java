package graeditor.flow.features;

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
				
				//字符串的拆分
				String string = eList.get(i).toString();
				String[] array = new String[20];
				array = string.split("/");
				if (array.length > 2) {
					String s2 = array[array.length-2];
					System.out.println(s2);
					diagramString = s2.substring(0, s2.length()-9);
					System.out.println("diagramString : " + diagramString);					
				}
			}
		}
		
		final Collection<Diagram> allDiagrams = getDiagrams();
		
		for (final Diagram d : allDiagrams) {
			if (d.getName().equals(diagramString)) {
				DiagramUtil.openDiagramEditor(d);
			}
		}
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
		return result;//result返回编辑器上同一个项目下所有的diagram图表信息，包括图表名称，并将这些diagram存在一个数组里
	}

}
