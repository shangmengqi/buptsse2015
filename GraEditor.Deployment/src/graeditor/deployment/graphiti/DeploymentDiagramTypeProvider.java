package graeditor.deployment.graphiti;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;


public class DeploymentDiagramTypeProvider extends AbstractDiagramTypeProvider{
	public DeploymentDiagramTypeProvider() {
		// TODO Auto-generated constructor stub
		super();
		setFeatureProvider(new DeploymentFeatureProvider(this));
	}

}
