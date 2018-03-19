package graeditor.vocabulary.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.graeditor.vocabulary_model.ClusterModule;
import com.graeditor.vocabulary_model.ConcurrentSetModule;
import com.graeditor.vocabulary_model.CondBranchModule;
import com.graeditor.vocabulary_model.ContHorzModule;
import com.graeditor.vocabulary_model.ContVertModule;
import com.graeditor.vocabulary_model.DecPointModule;
import com.graeditor.vocabulary_model.FileModule;
import com.graeditor.vocabulary_model.FileStackModule;
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

		//同一个节点不能既是连线起点又是连线终点
		if (startElement == null || endElement == null || (startElement == endElement)) {
			return false;
		}
		
		if (!(isQualified(startElement) && (isQualified(endElement)))) {
			return false;
		}
		
		startBizObj = (VocabularyModule) getBusinessObjectForPictogramElement(startElement);
		endBizObj = (VocabularyModule) getBusinessObjectForPictogramElement(endElement);
		
		// 如果当前连线早已存在,则不创建该链接
		
		if (startBizObj.getNext().contains(endBizObj)) {
			return false;
		}
		
		
		//文件元素和文件相似组不能作为连线起点
		if (startBizObj instanceof FileModule || startBizObj instanceof FileStackModule) {
			return false;
		}
		
		//连接点元素和连线点元素不能相连
		if (startBizObj instanceof ContHorzModule || startBizObj instanceof ContVertModule) {
			if (endBizObj instanceof ContHorzModule || endBizObj instanceof ContVertModule) {
				return false;
			}
		}
		
		//并发节点不能和并发节点、条件选择分支节点和汇聚节点相连
		if (startBizObj instanceof ConcurrentSetModule) {
			if (endBizObj instanceof ConcurrentSetModule || endBizObj instanceof CondBranchModule || endBizObj instanceof ClusterModule) {
				return false;
			}
		}
		
		//判断节点不能和汇聚节相连
		if (startBizObj instanceof DecPointModule) {
			if (endBizObj instanceof ClusterModule) {
				return false;
			}
		}
		
		
		return true;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
//		startBizObj.setNext(endBizObj);
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
		VocabularyModule startModule = (VocabularyModule) bizObj;
		if (startModule instanceof FileModule || startModule instanceof FileStackModule) {
			return false;
		}
		

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
