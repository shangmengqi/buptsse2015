package graeditor.structureview.features;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * drill down功能中提供关联功能的类
 * @author shhqin
 *
 */
public class AssociateDiagramFeature extends AbstractCustomFeature{

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
		// TODO 关联的处理函数，此处应该是获取所有的图表，让用户选择一个，
		
	}

}
