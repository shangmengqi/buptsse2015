package graeditor.deployment.graphiti;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;

import graeditor.deployment.features.AddConnectionFeature;
import graeditor.deployment.features.CreateConnectionFeature;
import graeditor.deployment.features.CreateConnectionFeature.ConnectionType;
import graeditor.deployment.pattern.NodePattern;
import graeditor.deployment.pattern.ProcessorNodePattern;

public class DeploymentFeatureProvider extends DefaultFeatureProviderWithPatterns{

	public DeploymentFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		addPattern(new NodePattern());
		addPattern(new ProcessorNodePattern());
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		if (context instanceof IAddConnectionContext) {
			return new AddConnectionFeature(this);
		}
		return super.getAddFeature(context);
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[]{
				new CreateConnectionFeature(this, ConnectionType.INPLEMENT),
				new CreateConnectionFeature(this, ConnectionType.DEPENDENCE)
		};
	}

}
