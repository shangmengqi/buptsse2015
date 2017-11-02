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
import graeditor.flow.features.AssociateDiagramFeature;
import graeditor.flow.features.CreateConnectionFeature;
import graeditor.flow.features.CreateConnectionFeature.ConnectionType;
import graeditor.flow.features.CustomBackAssociateDiagramFeature;
import graeditor.flow.features.CustomChangeTextFeature;
import graeditor.flow.features.CustomCompareLocalFeature;
import graeditor.flow.features.FlowDrillDownFeature;
import graeditor.flow.pattern.ContentPattern;
import graeditor.flow.pattern.ControlTagPattern;
import graeditor.flow.pattern.EndTagPattern;
import graeditor.flow.pattern.HorizontalLinePattern;
import graeditor.flow.pattern.PreLogInTagPattern;
import graeditor.flow.pattern.StartTagPattern;
import graeditor.flow.pattern.TitlePattern;
import graeditor.flow.pattern.VerticalLinePattern;
import graeditor.flow.features.CustomDeleteFeature;
public class FlowFeatureProvider extends DefaultFeatureProviderWithPatterns{

	public FlowFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		addPattern(new StartTagPattern());
		addPattern(new VerticalLinePattern());
		addPattern(new HorizontalLinePattern());
		addPattern(new EndTagPattern());
		addPattern(new ContentPattern());
		addPattern(new TitlePattern());
		addPattern(new PreLogInTagPattern());
		addPattern(new ControlTagPattern());
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		// �������connection�����
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
//		//ֻ�е��û�������ڲ���Text����ʱ�ŵ��ø�Feature
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
			new CustomChangeTextFeature(this),
			new FlowDrillDownFeature(this),
			new AssociateDiagramFeature(this),
			new CustomBackAssociateDiagramFeature(this),
			new CustomDeleteFeature(this),
			new CustomCompareLocalFeature(this)
			};
	}

}
