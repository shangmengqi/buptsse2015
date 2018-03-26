package graeditor.deployment.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.graeditor.deployment_model.DeploymentModule;


public class CreateConnectionFeature extends AbstractCreateConnectionFeature{
	
	public static enum ConnectionType{
		INPLEMENT,DEPENDENCE;
	}
	
	private ConnectionType type;

	public CreateConnectionFeature(IFeatureProvider fp, ConnectionType type) {
		super(fp, type.name(), "add a connection between two modules");
		this.type = type;
	}
	
	DeploymentModule startBizObj, endBizObj;

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
		
		startBizObj = (DeploymentModule) getBusinessObjectForPictogramElement(startElement);
		endBizObj = (DeploymentModule) getBusinessObjectForPictogramElement(endElement);
		
		// 如果当前连线早已存在,则不创建该链接
		if (startBizObj.getNext().contains(endBizObj)) {
			return false;
		}
		
		return true;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		endBizObj.setPreviousModules(startBizObj);
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
		return true;
	}
	
	private boolean isQualified(PictogramElement element){
		Object bizObject = getBusinessObjectForPictogramElement(element);
		if (bizObject == null || !(bizObject instanceof DeploymentModule)) {
			return false;
		}
		return true;
	}

}
