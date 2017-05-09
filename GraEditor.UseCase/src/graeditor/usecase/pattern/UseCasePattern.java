package graeditor.usecase.pattern;

import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.pattern.id.IdPattern;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import graeditor.usecase.provider.UseCaseImageProvider;
import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;
import usecase.Usecase;
import usecase.UsecaseFactory;

public class UseCasePattern extends IdPattern implements IPattern{
	private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant(209, 238, 238);
	private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant(102, 204, 255);
	
	public UseCasePattern() {
		super();
	}
	
	/* 
	 * 杩斿洖鍦∣bjects鍒楄〃涓殑鍚嶇О
	 */
	@Override
	public String getCreateName() {
		return "Usecase";
	}

	/* 
	 * 鍒ゆ柇鑳藉惁create
	 */
	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	/* 
	 * 鍒涘缓Usecase瀵硅薄
	 */
	@Override
	public Object[] create(ICreateContext context) {
		Usecase usecase = UsecaseFactory.eINSTANCE.createUsecase();
		usecase.setName("newUsecase");
		
		getDiagram().eResource().getContents().add(usecase);
		addGraphicalRepresentation(context, usecase);
		return new Object[] { usecase };
	}
	
	/* 
	 * 鍒ゆ柇鑳藉惁娣诲姞杩涙寚瀹氫綅缃�
	 */
	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}


	@Override
	protected PictogramElement doAdd(IAddContext context) {
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		Usecase addedDomainModel = (Usecase) context.getNewObject();
		
		// 鑾峰彇缁樺埗鍥惧舰鐨勪袱绉嶈祫婧�
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		
		
		
		int height = 70;
		int width = 170;

		
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		GraPropertyUtil.setValue(containerShape, "shape_id", "Usecase"+IDGenerator.generateID());
		
//	    Ellipse ellipse = gaService.createEllipse(containerShape);
//	    ellipse.setLineWidth(1);
//	    ellipse.setBackground(manageColor(E_CLASS_BACKGROUND));
//	    ellipse.setForeground(manageColor(E_CLASS_FOREGROUND));
//	    setId(containerShape, "circle");
//	    gaService.setLocationAndSize(ellipse, context.getX(), context.getY(), width, height);
//	    
		Image usecase = gaService.createImage(containerShape, UseCaseImageProvider.USECASE_REF);
		gaService.setLocationAndSize(usecase, context.getX(), context.getY(), width, height);

		
		Shape shape = peCreateService.createShape(containerShape, false);
		Text text = gaService.createText(shape, addedDomainModel.getName());
		text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
		setId(text, "text_id");
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(text, 0, 0, width, height);
		
		peCreateService.createChopboxAnchor(containerShape);
		
		link(containerShape, addedDomainModel);
		
//		link(shape, addedDomainModel);
		
		return containerShape;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		// TODO Auto-generated method stub
		return Reason.createFalseReason();
	}

	@Override
	protected boolean update(IdUpdateContext context, String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof Usecase;
	}

	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object domainObject  = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(domainObject);
	}

	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object domainObject  = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(domainObject);
	}

}
