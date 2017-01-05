package graeditor.usecase.features;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import usecase.Usecase;
import usecase.User;

public class CreateConnectionFeature extends AbstractCreateConnectionFeature{

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
		
		return (sourceDomainObject instanceof User) && (targetDomainObject instanceof Usecase);
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		// 在pattern的doAdd中需要创建anchor，否则此处会为null
		Anchor sourceAnchor = context.getSourceAnchor();
		Anchor targetAnchor = context.getTargetAnchor();
		
		// 如果终点的锚点在某个PE里，那么将锚点设为该PE
//		if (targetAnchor == null) {
//			Shape shape = (Shape) context.getTargetPictogramElement();
//			while (shape.getAnchors().isEmpty()){
//				shape = shape.getContainer();				
//			}
//			targetAnchor = shape.getAnchors().get(0);
//		}
		
		EObject sourceObject = (EObject) getBusinessObjectForPictogramElement(sourceAnchor.getParent());
		EObject targetObject = (EObject) getBusinessObjectForPictogramElement(targetAnchor.getParent());
		
		
		// 具体的判断逻辑
		if (sourceObject instanceof User) {
			if (targetObject instanceof Usecase) {
				((User) sourceObject).getUsecase().add((Usecase) targetObject);
			} else {
				throw new IllegalStateException("用户只能拥有用例");
			}
		} else if (sourceObject instanceof Usecase) {
			if (targetObject instanceof User) {
				((User) targetObject).getUsecase().add((Usecase) sourceObject);
			} else {
				throw new IllegalStateException("用户只能拥有用例");
			}
		} else {
			throw new IllegalStateException("未知错误");
		}
		
		// 创建一个context，交由FeatureProvider来进行处理
		AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
		getFeatureProvider().addIfPossible(addContext);
		
		return null;
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		Object domainObject = getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
		return domainObject instanceof User;
	}

}
