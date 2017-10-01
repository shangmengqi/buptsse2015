package graeditor.structureview.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import StructureView.File;
import StructureView.FileGroup;
import StructureView.Page;
import StructureView.PageGroup;

public class CreateConnectionFeature extends AbstractCreateConnectionFeature {

	public CreateConnectionFeature(IFeatureProvider fp, String name, String description) {
		super(fp, name, description);
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		PictogramElement sourcePictogramElement = context.getSourcePictogramElement();
		PictogramElement targetPictogramElement = context.getTargetPictogramElement();

		if (sourcePictogramElement == null || targetPictogramElement == null) {
			return false;
		}

		Object sourceDomainObject = getBusinessObjectForPictogramElement(sourcePictogramElement);
		Object targetDomainObject = getBusinessObjectForPictogramElement(targetPictogramElement);

		if (sourceDomainObject instanceof Page) {
			if (targetDomainObject instanceof Page) {
				if (sourceDomainObject == targetDomainObject) { // 不能从自身到自身的关联
					return false;
				} else {
					return true;
				}
			} else if (targetDomainObject instanceof PageGroup) {
				return true;
			} else if (targetDomainObject instanceof File) {
				return true;
			} else if (targetDomainObject instanceof FileGroup) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Anchor sourceAnchor = context.getSourceAnchor();
		Anchor targetAnchor = context.getTargetAnchor();
		
		EObject sourceObject = (EObject) getBusinessObjectForPictogramElement(sourceAnchor.getParent());
		EObject targetObject = (EObject) getBusinessObjectForPictogramElement(targetAnchor.getParent());
		
		// 具体的判断逻辑
		if (sourceObject instanceof Page) {
			if (targetObject instanceof Page) {
				((Page) sourceObject).getPage().add((Page) targetObject);
			} else if (targetObject instanceof PageGroup) {
				((Page) sourceObject).getPagegroup().add((PageGroup) targetObject);
			} else if (targetObject instanceof File) {
				((Page) sourceObject).getFile().add((File) targetObject);
			} else if (targetObject instanceof FileGroup) {
				((Page) sourceObject).getFilegroup().add((FileGroup) targetObject);
			} else {
				throw new IllegalStateException("页面只能拥有页面、页面组、文件、文件组");
			}
			
		} else {
			throw new IllegalStateException("未知错误，StructureView createConnectionFeature");
		}
		
		// 创建一个context，交由FeatureProvider来进行处理
		AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
		getFeatureProvider().addIfPossible(addContext);
		
		return null;
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		Object domainObject = getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
		return domainObject instanceof Page;
	}

}
