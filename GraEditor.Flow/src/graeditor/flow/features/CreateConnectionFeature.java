package graeditor.flow.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.graeditor.flow_model.ContentModule;
import com.graeditor.flow_model.EndTagModule;
import com.graeditor.flow_model.FlowModule;
import com.graeditor.flow_model.PreLogInTagModule;
import com.graeditor.flow_model.StartTagModule;

public class CreateConnectionFeature extends AbstractCreateConnectionFeature{
	
	public static enum ConnectionType{
		FREEFORM,MANHATTAN;
	}
	
	private ConnectionType type;

	public CreateConnectionFeature(IFeatureProvider fp, ConnectionType type) {
		super(fp, type.name(), "add a connection between two modules");
		this.type = type;
	}
	
	FlowModule startBizObj, endBizObj;

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		PictogramElement startElement = context.getSourcePictogramElement();
		PictogramElement endElement = context.getTargetPictogramElement();
		
		if (startElement == null || endElement == null || (startElement == endElement)) {
			return false;
		}
		
		if (!(isQualified(startElement) && (isQualified(endElement)))) {
			return false;
		}
		
		startBizObj = (FlowModule) getBusinessObjectForPictogramElement(startElement);
		endBizObj = (FlowModule) getBusinessObjectForPictogramElement(endElement);
		
		// 如果当前连线早已存在
		if (endBizObj.getPreviousModules().contains(startBizObj)) {
			return false;
		}
		
		//�����ǰ���������Ѿ�����
//		if (startBizObj.getPreviousModules().contains(endBizObj)) {
//			return false;
//		}
		
		//StartTagModuleֻ�����ӵ�ContentModule��
//		if (startBizObj instanceof StartTagModule) {
//			if (endBizObj instanceof EndTagModule) {
//				return false;
//			}
//		}
		
		// 开始节点不能连接到结束节点上
		if (startBizObj instanceof PreLogInTagModule) {
			if (endBizObj instanceof EndTagModule) {
				return false;
			}
		}
		
		//ContentModuleֻ�����ӵ�ContentModule����EndTagModule��
		// content节点不能连接到开始和登录节点
//		if (startBizObj instanceof ContentModule) {
//			if (endBizObj instanceof StartTagModule) {
//				return false;
//			}
//		}
		
		// 登录节点不可以连接开始节点
		if (startBizObj instanceof StartTagModule) {
			if (endBizObj instanceof PreLogInTagModule) {
				return false;
			}
		}
		
		// endTag不能作为连线的起点
		if (startBizObj instanceof EndTagModule) {
			return false;
		}
		
		// 开始节点不能作为连线的终点
		if (endBizObj instanceof PreLogInTagModule) {
			return false;
		}
		
		// 
//		if (startBizObj instanceof PreLogInTagModule) {
//			if (startBizObj.getNext() instanceof ) {
//				
//			}
//		}
		
		
		
		return true;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		/*
		 * ��һ���ǳ���Ҫ
		 */
		startBizObj.setNext(endBizObj);
		//�������������Ҫ�����ֶ�����������������յ��ê
		AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
		addContext.setNewObject(type);
		Connection newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
		return newConnection;
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		PictogramElement startElement = context.getSourcePictogramElement();
		
		if (!(isQualified(startElement))) {
			return false;
		}
		
		Object bizObj = getBusinessObjectForPictogramElement(startElement);
		FlowModule startModule = (FlowModule) bizObj;
		if (startModule instanceof EndTagModule) {
			return false;
		}else if (startModule instanceof StartTagModule) {
			if (startModule.getNext() != null) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ֻ��������PictogramElement���д���Connection���ʸ�
	 * 
	 */
	private boolean isQualified(PictogramElement element){
		Object bizObject = getBusinessObjectForPictogramElement(element);
		if (bizObject == null || !(bizObject instanceof FlowModule)) {
			return false;
		}
		return true;
	}

}
