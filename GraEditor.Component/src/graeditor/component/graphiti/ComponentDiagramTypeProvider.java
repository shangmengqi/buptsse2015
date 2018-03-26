package graeditor.component.graphiti;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;


public class ComponentDiagramTypeProvider extends AbstractDiagramTypeProvider{

	public ComponentDiagramTypeProvider() {
		// TODO Auto-generated constructor stub
		super();
		setFeatureProvider(new ComponentFeatureProvider(this));
	}
}
