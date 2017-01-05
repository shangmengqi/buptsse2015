package graeditor.flowview.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;

public class CreateConnectionFeature extends AbstractCreateConnectionFeature{

	public CreateConnectionFeature(IFeatureProvider fp, String name, String description) {
		super(fp, name, description);
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
