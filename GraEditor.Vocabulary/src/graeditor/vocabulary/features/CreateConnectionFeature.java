package graeditor.vocabulary.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;


import com.graeditor.vocabulary_model.PageModule;
import com.graeditor.vocabulary_model.VocabularyModule;


public class CreateConnectionFeature extends AbstractCreateConnectionFeature{
	
	public static enum ConnectionType{
		FREEFORM,MANHATTAN;
	}
	
	private ConnectionType type;

	public CreateConnectionFeature(IFeatureProvider fp, ConnectionType type) {
		super(fp, type.name(), "add a connection between two modules");
		this.type = type;
	}
	
	VocabularyModule startBizObj, endBizObj;

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
		
		startBizObj = (VocabularyModule) getBusinessObjectForPictogramElement(startElement);
		endBizObj = (VocabularyModule) getBusinessObjectForPictogramElement(endElement);
		
		// 如果当前连线早已存在,则不创建该链接
		if (endBizObj.getPreviousModules().contains(startBizObj)) {
			return false;
		}
		
		return true;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
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
		
//		Object bizObj = getBusinessObjectForPictogramElement(startElement);
//		VocabularyModule startModule = (VocabularyModule) bizObj;
//		if (startModule instanceof PageModule) {
//			if (startModule.getNext() != null) {
//				return false;
//			}
//		}
		return true;
	}
	
	private boolean isQualified(PictogramElement element){
		Object bizObject = getBusinessObjectForPictogramElement(element);
		if (bizObject == null || !(bizObject instanceof VocabularyModule)) {
			return false;
		}
		return true;
	}

}
