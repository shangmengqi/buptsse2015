package graeditor.flowview.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class FlowViewDiagramTypeProvider extends AbstractDiagramTypeProvider {

	public FlowViewDiagramTypeProvider() {
		super();
		setFeatureProvider(new FlowViewFeatureProvider(this));
	}
}
