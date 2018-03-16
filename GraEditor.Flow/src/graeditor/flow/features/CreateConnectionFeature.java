package graeditor.flow.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.graeditor.flow_model.ContentModule;
import com.graeditor.flow_model.ControlTagModule;
import com.graeditor.flow_model.EndTagModule;
import com.graeditor.flow_model.FenChaModule;
import com.graeditor.flow_model.FlowModule;
import com.graeditor.flow_model.HeBingModule;
import com.graeditor.flow_model.HuiHeModule;
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
		
		// 如果当前连线早已存在,则不创建该链接
		if (endBizObj.getPreviousModules().contains(startBizObj)) {
			return false;
		}
		
		// 开始节点不能连接到结束节点、汇合节点、合并节点上
		if (startBizObj instanceof PreLogInTagModule) {
			if (endBizObj instanceof EndTagModule || endBizObj instanceof HuiHeModule || endBizObj instanceof HeBingModule) {
				return false;
			}
		}
		
		// 终止节点无出连线
		if (startBizObj instanceof EndTagModule) {
			return false;
		}
		
		// 开始节点无入连线
		if (endBizObj instanceof PreLogInTagModule) {
			return false;
		}
		
		//分支节点只有一个入度
		if (endBizObj instanceof ControlTagModule) {
			if (endBizObj.getPreviousModules().size() == 1) {
				return false;
			}			
		}
				
		//合并节点只有两个入度
		if (endBizObj instanceof HeBingModule) {
			if (endBizObj.getPreviousModules().size() == 2) {
				return false;
			}
		}
		
		//分叉节点只有一个入度
		if (endBizObj instanceof FenChaModule) {
			if (endBizObj.getPreviousModules().size() == 1) {
				return false;
			}
		}
				
		
		// 登录节点不可以连接开始节点
		if (startBizObj instanceof StartTagModule) {
			if (endBizObj instanceof PreLogInTagModule) {
				return false;
			}
		}
		
				
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
