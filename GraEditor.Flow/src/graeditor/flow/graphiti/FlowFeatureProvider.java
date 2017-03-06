package graeditor.flow.graphiti;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;

import graeditor.flow.features.AddConnectionFeature;
import graeditor.flow.features.CreateConnectionFeature;
import graeditor.flow.features.CreateConnectionFeature.ConnectionType;
import graeditor.flow.features.CustomChangeTextFeature;
import graeditor.flow.pattern.ContentPattern;
import graeditor.flow.pattern.EndTagPattern;
import graeditor.flow.pattern.HorizontalLinePattern;
import graeditor.flow.pattern.StartTagPattern;
import graeditor.flow.pattern.TitlePattern;
import graeditor.flow.pattern.VerticalLinePattern;
public class FlowFeatureProvider extends DefaultFeatureProviderWithPatterns{

	public FlowFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		addPattern(new StartTagPattern());
		addPattern(new VerticalLinePattern());
		addPattern(new HorizontalLinePattern());
		addPattern(new EndTagPattern());
		addPattern(new ContentPattern());
		addPattern(new TitlePattern());
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		// 处理添加connection的情况
		if (context instanceof IAddConnectionContext) {
			return new AddConnectionFeature(this);
		}
		return super.getAddFeature(context);
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[]{
				new CreateConnectionFeature(this, ConnectionType.FREEFORM),
				new CreateConnectionFeature(this, ConnectionType.MANHATTAN)
		};
	}
	
//	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context){
//		//只有当用户点击到内部的Text区域时才调用该Feature
//		if (context.getPictogramElement().getGraphicsAlgorithm() instanceof Text) {
//			return new ModuleDirectEditFeature(this);
//		}
//		return super.getDirectEditingFeature(context);
//	}
//	
//	public IUpdateFeature getUpdateFeature(IUpdateContext context){
//		return new ModuleUpdateFeature(this);
//	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] {				
			new CustomChangeTextFeature(this)};
	}

}
