package graeditor.relation.features;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.graeditor.relation_model.Relation;
import com.graeditor.relation_model.RelationModule;

public class AssociateDiagramFeature extends AbstractCustomFeature {

	public AssociateDiagramFeature(IFeatureProvider fp) {
		super(fp);
		System.out.println("Associate1");
	}
	
	@Override
    public String getName() {
		System.out.println("Associate2");
        return "Associate diagram";
    }
	 
	@Override
    public String getDescription() {
		System.out.println("Associate3");
        return "Associate the diagram with this EClass";
    }
	
	@Override
    public boolean canExecute(ICustomContext context) {
		System.out.println("Associate4/canExecute");
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length >= 1) {
            ret = true;
            for (PictogramElement pe : pes) {
                Object bo = getBusinessObjectForPictogramElement(pe);
                if (! (bo instanceof RelationModule)) {
                    ret = false;
                }                
            }
        }
        return ret;
    }

	@Override
	public void execute(ICustomContext context) {
		System.out.println("Associate5/execute");
		PictogramElement[] pes = context.getPictogramElements();
		RelationModule relations[] = new RelationModule[pes.length];
		for (int i = 0; i < relations.length; i++) {
			relations[i] = (RelationModule)getBusinessObjectForPictogramElement(pes[i]);
			
		}
		link(getDiagram(), relations);
	}

}
