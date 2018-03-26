package graeditor.deployment.graphiti;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;

public class DeploymentFeatureProvider extends DefaultFeatureProviderWithPatterns{

	public DeploymentFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

}
