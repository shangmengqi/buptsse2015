package graeditor.flow.graphiti;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;


public class FlowDiagramTypeProvider extends AbstractDiagramTypeProvider{

	public FlowDiagramTypeProvider(){
		super();
		setFeatureProvider(new FlowFeatureProvider(this));
	}
	
	IToolBehaviorProvider[] toolBehaviorProviders;
	
	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			toolBehaviorProviders = new IToolBehaviorProvider[]{
				new FlowViewToolBehaviorProvider(this)
			};
		}
		return toolBehaviorProviders;
	}
}
