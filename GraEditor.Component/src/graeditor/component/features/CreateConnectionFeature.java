package graeditor.component.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;


public class CreateConnectionFeature extends AbstractCreateConnectionFeature{
	
	public static enum ConnectionType{
		FREEFORM,MANHATTAN;
	}
	
	private ConnectionType type;

	public CreateConnectionFeature(IFeatureProvider fp, ConnectionType type) {
		super(fp, type.name(), "add a connection between two modules");
		this.type = type;
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
