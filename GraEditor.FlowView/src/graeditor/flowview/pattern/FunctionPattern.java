package graeditor.flowview.pattern;

import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
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

import FlowView.FlowViewFactory;
import FlowView.Function;
import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;
import graeditor.utils.ValueUtil;

public class FunctionPattern extends IdPattern implements IPattern{
	private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant(98, 131, 167);
	private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant(187, 218, 247);
	private static final IColorConstant E_CLASS_WHITE = new ColorConstant(255, 255, 255);
	
	public FunctionPattern () {
		super();
	}
	
	@Override
	public String getCreateName() {
		return "Function";
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		Function newFunction = FlowViewFactory.eINSTANCE.createFunction();
		newFunction.setName("newFunction");
		
		getDiagram().eResource().getContents().add(newFunction);
		addGraphicalRepresentation(context, newFunction);
		return new Object[] { newFunction };
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		Function addedDomainModel = (Function) context.getNewObject();
		
//		int width = 450;
		int height = 300;
		
		// 获取绘制图形的两种资源
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		
		GraPropertyUtil.setValue(containerShape, ValueUtil.SHAPE_ID, ValueUtil.FLOWVIEW_FUNCTION+IDGenerator.generateID());
		
		Rectangle rectangle = gaService.createRectangle(containerShape);
		rectangle.setLineWidth(2);
		rectangle.setForeground(manageColor(E_CLASS_FOREGROUND));
		rectangle.setBackground(manageColor(E_CLASS_WHITE));
		gaService.setLocationAndSize(rectangle, context.getX(), context.getY(), ValueUtil.FLOWVIEW_VIEW_WIDTH + ValueUtil.TEXT_HEIGHT, height);
		
		link(containerShape, addedDomainModel);
		
		// 创建横线
		final Shape horizontalLineShape = peCreateService.createShape(containerShape, false);
		final Polyline horizontalPolyline = gaService.createPlainPolyline(horizontalLineShape, new int[] { 0, ValueUtil.TEXT_HEIGHT, ValueUtil.FLOWVIEW_VIEW_WIDTH, ValueUtil.TEXT_HEIGHT });
		
		
		// 创建竖线
		final Shape verticalLineShape = peCreateService.createShape(containerShape, false);
		final Polyline verticalPolyline = gaService.createPlainPolyline(verticalLineShape, new int[] { ValueUtil.TEXT_HEIGHT, ValueUtil.TEXT_HEIGHT, ValueUtil.TEXT_HEIGHT, height });
		
		
		return containerShape;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		return Reason.createFalseReason();
	}

	@Override
	protected boolean update(IdUpdateContext context, String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* 
	 * 此处必须为该Pattern所对应的Ecore接口，否则无法调用canAdd函数
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof Function;
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
