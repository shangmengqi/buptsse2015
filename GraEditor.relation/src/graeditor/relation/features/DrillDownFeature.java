package graeditor.relation.features;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractDrillDownFeature;

import com.graeditor.relation_model.Relation;
import com.graeditor.relation_model.RelationModule;

import graeditor.utils.DiagramUtil;

public class DrillDownFeature extends AbstractDrillDownFeature{

	public DrillDownFeature(IFeatureProvider fp) {	
		super(fp);
		System.out.println("DrillDown1");
	}
	
	@Override
	public String getName() {
		System.out.println("DrillDown2");
		return "Open assosiated diagram";		
	}
	
	@Override
    public String getDescription() {
		System.out.println("DrillDown3");
        return "Open the diagram associated with this EClass";
    }
	
	@Override
	public boolean canExecute(ICustomContext context) {
		System.out.println("DrillDown4/canExecute");
		//返回一个Graphiti图形对象
		PictogramElement[] pes = context.getPictogramElements();
        // first check, if one EClass is selected
        if (pes != null && pes.length == 1) {
        	//返回通过link方法绑定的EMF模型对象
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof RelationModule) {
                // then forward to super-implementation, which checks if
                // this EClass is associated with other diagrams
                return super.canExecute(context);
            }
        }
        return false;
	}

	@Override
	protected Collection<Diagram> getDiagrams() {
		System.out.println("DrillDown5/Collection");
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
		return result;
	}

}
