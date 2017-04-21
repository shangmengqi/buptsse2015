package graeditor.relation.features;


import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;


import com.graeditor.relation_model.RelationModule;

public class AssociateDiagramFeature extends AbstractCustomFeature {

	public AssociateDiagramFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
    public String getName() {
        return "Associate diagram";
    }
	 
	@Override
    public String getDescription() {
        return "Associate the diagram with this EClass";
    }
	
	@Override
    public boolean canExecute(ICustomContext context) {
		
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
		PictogramElement[] pes = context.getPictogramElements();
		for (int i = 0; i < pes.length; i++) {
			System.out.println("pesName: " + pes[i].eResource());
			RelationModule relations[] = new RelationModule[pes.length];
			for (int j = 0; j < relations.length; j++) {
				relations[j] = (RelationModule)getBusinessObjectForPictogramElement(pes[j]);
				System.out.println("relations: " + relations[j].getTextContent());
			}
			System.out.println("pes: " + pes.length);
			System.out.println("getDiagram(): " + getDiagram());
			System.out.println("relations: " + relations.length);
			System.out.println("relations: " + relations);
			link(getDiagram(), relations);
		}
		
		
	}

}
