package graeditor.component.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.graeditor.component_model.ComponentModule;
import com.graeditor.component_model.LittleInterfaceModule;


public class CreateConnectionFeature extends AbstractCreateConnectionFeature{

	public static enum ConnectionType{
		INPLEMENT,DEPENDENCE;
	}
	
	private ConnectionType type;
	
	public CreateConnectionFeature(IFeatureProvider fp, ConnectionType type) {		
		super(fp,type.name(), "add a connection between two modules");
		this.type = type;
	}

	ComponentModule startBizObj, endBizObj;

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
		
		startBizObj = (ComponentModule) getBusinessObjectForPictogramElement(startElement);
		endBizObj = (ComponentModule) getBusinessObjectForPictogramElement(endElement);
		
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
		
		Object bizObj = getBusinessObjectForPictogramElement(startElement);
		ComponentModule startModule = (ComponentModule) bizObj;
		if (startModule instanceof LittleInterfaceModule) {
			return false;
		}
		return true;
	}
	
	private boolean isQualified(PictogramElement element){
		Object bizObject = getBusinessObjectForPictogramElement(element);
		if (bizObject == null || !(bizObject instanceof ComponentModule)) {
			return false;
		}
		return true;
	}

}
