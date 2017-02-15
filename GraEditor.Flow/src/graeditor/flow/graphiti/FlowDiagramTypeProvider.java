package graeditor.flow.graphiti;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;


public class FlowDiagramTypeProvider extends AbstractDiagramTypeProvider{

	public FlowDiagramTypeProvider(){
		super();
		setFeatureProvider(new FlowFeatureProvider(this));
	}
}
