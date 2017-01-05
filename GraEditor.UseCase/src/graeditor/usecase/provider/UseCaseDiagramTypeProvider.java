package graeditor.usecase.provider;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class UseCaseDiagramTypeProvider extends AbstractDiagramTypeProvider{
	private IToolBehaviorProvider[] toolBehaviorProviders = null;
	
	public UseCaseDiagramTypeProvider() {
		super();
		setFeatureProvider(new UseCaseDiagramFeatureProvider(this));
	}

	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (null == toolBehaviorProviders) {
			toolBehaviorProviders = new IToolBehaviorProvider[] { new UseCaseToolBehaviorProvider(this) };
		}
		return toolBehaviorProviders;
	}

	@Override
	public boolean isAutoUpdateAtRuntimeWhenEditorIsSaved() {
		// TODO Auto-generated method stub
		return true;
	}
}
