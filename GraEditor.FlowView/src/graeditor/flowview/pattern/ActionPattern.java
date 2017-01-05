package graeditor.flowview.pattern;

import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.pattern.id.IdPattern;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;

public class ActionPattern extends IdPattern implements IPattern{

	@Override
	public String getCreateName() {
		// TODO Auto-generated method stub
		return super.getCreateName();
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		// TODO Auto-generated method stub
		return super.canCreate(context);
	}

	@Override
	public Object[] create(ICreateContext context) {
		// TODO Auto-generated method stub
		return super.create(context);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		// TODO Auto-generated method stub
		return super.canAdd(context);
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean update(IdUpdateContext context, String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		// TODO Auto-generated method stub
		return super.isPatternControlled(pictogramElement);
	}

	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		// TODO Auto-generated method stub
		return super.isPatternRoot(pictogramElement);
	}

}
