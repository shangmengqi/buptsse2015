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
		
		//如果当前的连接早已经存在
		if (startBizObj.getPreviousModules().contains(endBizObj)) {
			return false;
		}
		
		//StartTagModule只能连接到ContentModule上
		if (startBizObj instanceof StartTagModule) {
			if (endBizObj instanceof EndTagModule) {
				return false;
			}
		}
		
		//ContentModule只能连接到ContentModule或者EndTagModule上
		if (startBizObj instanceof ContentModule) {
			if (endBizObj instanceof StartTagModule) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		/*
		 * 这一步非常重要
		 */
		startBizObj.setNext(endBizObj);
		//这里的上下文需要我们手动构建，传入起点与终点的锚
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
	 * 只有最外层的PictogramElement才有创建Connection的资格
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
