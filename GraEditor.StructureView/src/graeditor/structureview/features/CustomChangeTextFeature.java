package graeditor.structureview.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

import graeditor.utils.DiagramUtil;

public class CustomChangeTextFeature extends AbstractCustomFeature {

	public CustomChangeTextFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public String getName() {
		return "Change Text";
	}
	
	@Override
    public String getDescription() {
        return "Change the displaying text of this Element";
    }
	
	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		DiagramUtil.changeText(context, context.getPictogramElements()[0]);
	}

}
