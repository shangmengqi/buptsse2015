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
//	 * ��һ��
//	 */
//	@Override
//	public boolean canDirectEdit(IDirectEditingContext context) {
//		//�˴��Ĵ����������͵�SampleExampleModule�������
//		FlowModule module = (FlowModule)FlowUtil.getModuleByInnerPictogramElement(getFeatureProvider(),
//				context.getPictogramElement());
//		//�����ս���ǲ����������
//		if (module instanceof EndTagModule) {
//			return false;
//		}
//		return true;
//	}
//	
//	/**
//	 * �ڶ���
//	 * ֻ��canDirectEdit��������true�˲Ż�ִ������
//	 * ����null��ʾ˳���޸�
//	 */
//	@Override
//	public String checkValueValid(String value, IDirectEditingContext context) {
//		return null;
//	}
//
//	/**
//	 * ����ڶ���ʧ�ܣ�ͨ���˷������ԭʼֵ
//	 */
//	@Override
//	public String getInitialValue(IDirectEditingContext context) {
//		FlowModule module = (FlowModule)FlowUtil.getModuleByInnerPictogramElement(getFeatureProvider(),
//				context.getPictogramElement());
//		return module.getTextContent();
//	}
//	
//	/**
//	 * ������
//	 * �ڴ˴��޸�EMFģ�͵�ֵ�����ҵ���ModuleUpdateFeature
//	 */
//	public void setValue(String value, IDirectEditingContext context){
//		FlowModule module = (FlowModule)FlowUtil.getModuleByInnerPictogramElement(getFeatureProvider()
//				, context.getPictogramElement());
//		module.setTextContent(value + "");
//		//����ModuleUpdateFeature��update����
//		updatePictogramElement(context.getPictogramElement());
//	}
//
//}
