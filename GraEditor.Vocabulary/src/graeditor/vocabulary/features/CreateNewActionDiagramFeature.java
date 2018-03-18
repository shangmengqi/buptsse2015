package graeditor.vocabulary.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.graeditor.vocabulary_model.VocabularyModule;

public class CreateNewActionDiagramFeature extends AbstractCustomFeature{

	public CreateNewActionDiagramFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
    public String getName() {
        return "Create associated action diagram";
    }
 
    @Override
    public String getDescription() {
        return "Create new action Diagram";
    }
    
    @Override
    public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        final PictogramElement pe = context.getPictogramElements()[0]; //获取当前被选择的元素
        VocabularyModule selectModule = (VocabularyModule) getBusinessObjectForPictogramElement(pe);
        if (pes != null && pes.length >= 1) {
        	if (selectModule.getNext() != null) {
        		ret = true;
			}           
        }
        return ret;
    }

	@Override
	public void execute(ICustomContext context) {
		// TODO Auto-generated method stub
		
	}

}
