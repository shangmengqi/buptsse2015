//package graeditor.flow.features;
//
//import org.eclipse.graphiti.features.IFeatureProvider;
//import org.eclipse.graphiti.features.context.IDirectEditingContext;
//import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
//
//import com.graeditor.flow_model.EndTagModule;
//import com.graeditor.flow_model.FlowModule;
//
//import graeditor.flow.util.FlowUtil;
//
//public class ModuleDirectEditFeature extends AbstractDirectEditingFeature{
//
//	public ModuleDirectEditFeature(IFeatureProvider fp) {
//		super(fp);
//	}
//
//	@Override
//	public int getEditingType() {
//		return TYPE_TEXT;
//	}
//	
//	/**
//	 * 第一步
//	 */
//	@Override
//	public boolean canDirectEdit(IDirectEditingContext context) {
//		//此处的代码所有类型的SampleExampleModule都会检验
//		FlowModule module = (FlowModule)FlowUtil.getModuleByInnerPictogramElement(getFeatureProvider(),
//				context.getPictogramElement());
//		//但是终结符是不允许操作的
//		if (module instanceof EndTagModule) {
//			return false;
//		}
//		return true;
//	}
//	
//	/**
//	 * 第二步
//	 * 只有canDirectEdit方法返回true了才会执行这里
//	 * 返回null表示顺利修改
//	 */
//	@Override
//	public String checkValueValid(String value, IDirectEditingContext context) {
//		return null;
//	}
//
//	/**
//	 * 如果第二步失败，通过此方法获得原始值
//	 */
//	@Override
//	public String getInitialValue(IDirectEditingContext context) {
//		FlowModule module = (FlowModule)FlowUtil.getModuleByInnerPictogramElement(getFeatureProvider(),
//				context.getPictogramElement());
//		return module.getTextContent();
//	}
//	
//	/**
//	 * 第三步
//	 * 在此处修改EMF模型的值，并且调用ModuleUpdateFeature
//	 */
//	public void setValue(String value, IDirectEditingContext context){
//		FlowModule module = (FlowModule)FlowUtil.getModuleByInnerPictogramElement(getFeatureProvider()
//				, context.getPictogramElement());
//		module.setTextContent(value + "");
//		//调用ModuleUpdateFeature的update方法
//		updatePictogramElement(context.getPictogramElement());
//	}
//
//}
