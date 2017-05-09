package graeditor.relation.graphiti;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class RelationDiagramTypeProvider extends AbstractDiagramTypeProvider{
	
	private IToolBehaviorProvider[] toolBehaviorProviders;

	public RelationDiagramTypeProvider() {
		super();
		setFeatureProvider(new RelationFeatureProvider(this));
	}
	
	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			toolBehaviorProviders = new IToolBehaviorProvider[] { new RelationViewToolBehaviorProvider(this) };
		}
		return toolBehaviorProviders;
	}
}
