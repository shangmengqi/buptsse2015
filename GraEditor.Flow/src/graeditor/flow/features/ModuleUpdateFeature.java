//package graeditor.flow.features;
//
//import org.eclipse.graphiti.features.IFeatureProvider;
//import org.eclipse.graphiti.features.IReason;
//import org.eclipse.graphiti.features.context.IUpdateContext;
//import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
//import org.eclipse.graphiti.features.impl.Reason;
//import org.eclipse.graphiti.mm.algorithms.Text;
//
//import com.graeditor.flow_model.FlowModule;
//
//import graeditor.flow.util.FlowUtil;
//
//public class ModuleUpdateFeature extends AbstractUpdateFeature{
//
//	public ModuleUpdateFeature(IFeatureProvider fp) {
//		super(fp);
//	}
//
//	@Override
//	public boolean canUpdate(IUpdateContext context) {
//		return context.getPictogramElement().getGraphicsAlgorithm() instanceof Text;
//	}
//
//	@Override
//	public IReason updateNeeded(IUpdateContext context) {
//		return Reason.createFalseReason();
//	}
//
//	/**
//	 * 第四步
//	 */
//	@Override
//	public boolean update(IUpdateContext context) {
//		FlowModule module = (FlowModule)FlowUtil.getModuleByInnerPictogramElement(getFeatureProvider(),
//				context.getPictogramElement());
//		//修改界面中的显示信息
//		Text text = (Text)context.getPictogramElement().getGraphicsAlgorithm();
//		text.setValue(module.getTextContent() + "");
//		return true;
//	}
//
//}
