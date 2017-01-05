package graeditor.flowview.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;

import graeditor.flowview.features.AddConnectionFeature;
import graeditor.flowview.features.CreateConnectionFeature;
import graeditor.flowview.pattern.FunctionPattern;
import graeditor.flowview.pattern.ViewPattern;


public class FlowViewFeatureProvider extends DefaultFeatureProviderWithPatterns {

	public FlowViewFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		// 添加patterns
		addPattern(new FunctionPattern());
		addPattern(new ViewPattern());
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] { new CreateConnectionFeature(this, "has", "Functions have Views")};
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		// 处理添加connection的情况
		if (context instanceof IAddConnectionContext) {
			return new AddConnectionFeature(this);
		}
		return super.getAddFeature(context);
	}
}
