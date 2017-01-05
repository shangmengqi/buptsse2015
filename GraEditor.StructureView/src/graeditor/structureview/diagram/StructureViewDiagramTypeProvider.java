package graeditor.structureview.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class StructureViewDiagramTypeProvider extends AbstractDiagramTypeProvider {
	private IToolBehaviorProvider[] toolBehaviorProviders;

	public StructureViewDiagramTypeProvider() {
		super();
		setFeatureProvider(new StructureViewFeatureProvider(this));
	}

	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			toolBehaviorProviders = new IToolBehaviorProvider[] { new StructureViewToolBehaviorProvider(this) };
		}
		return toolBehaviorProviders;
	}
}
