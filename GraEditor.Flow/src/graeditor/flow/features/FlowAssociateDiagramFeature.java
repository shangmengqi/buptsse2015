package graeditor.flow.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.graeditor.flow_model.FlowModule;


public class FlowAssociateDiagramFeature extends AbstractCustomFeature{

	public FlowAssociateDiagramFeature(IFeatureProvider fp) {
		super(fp);
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
		boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length >= 1) {
            ret = true;
//            for (PictogramElement pe : pes) {
//                Object bo = getBusinessObjectForPictogramElement(pe);
//                if (! (bo instanceof EClass)) {
//                    ret = false;
//                }                
//            }
        }
        return ret;
    }

	@Override
	public void execute(ICustomContext context) {
		// TODO Auto-generated method stub
//		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement[] pes = context.getPictogramElements();
		FlowModule flows[] = new FlowModule[pes.length];
		for (int i = 0; i < flows.length; i++) {
			flows[i] = (FlowModule)getBusinessObjectForPictogramElement(pes[i]);
			
		}
		link(getDiagram(), flows);
		
	}

}
