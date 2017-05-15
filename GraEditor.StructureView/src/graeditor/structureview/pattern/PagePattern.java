package graeditor.structureview.pattern;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
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

import StructureView.Page;
import StructureView.StructureViewFactory;
import graeditor.structureview.diagram.StructureViewImageProvider;
import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;

public class PagePattern extends IdPattern implements IPattern{

	public PagePattern() {
		super();
	}

	@Override
	public String getCreateName() {
		return "Page";
	}

	/* 
	 * 判断Page能否添加，在diagram中才能添加
	 */
	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	/* 
	 * 创建一个Page实例
	 */
	@Override
	public Object[] create(ICreateContext context) {
		
		int i;
		i = getDiagram().getPictogramLinks().size() + 1;
		String ret = ExampleUtil.askString("Text", "Please input a text", "Page" + i);
		String value = "s";
		try {
			value = ret;
		} catch (Exception e) {
		}
		
		Page newPage = StructureViewFactory.eINSTANCE.createPage();
		newPage.setName(value);
		
		
		getDiagram().eResource().getContents().add(newPage);
		addGraphicalRepresentation(context, newPage);
		return new Object[] { newPage };
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		Page addedDomainModel = (Page) context.getNewObject();
		
		int width = 150;
		int height = 100;
		int text_height = 20;
		
		// 获取绘制图形的两种资源
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		GraPropertyUtil.setValue(containerShape, "shape_id", "Page"+IDGenerator.generateID());
		
//		Rectangle rectangle = gaService.createRectangle(containerShape);
//		rectangle.setForeground(manageColor(E_CLASS_FOREGROUND));
//		rectangle.setBackground(manageColor(E_CLASS_BACKGROUND));
//		rectangle.setLineWidth(2);
//		setId(containerShape, "user_id");
//		gaService.setLocationAndSize(rectangle, context.getX(), context.getY(), width, height);
//		
//		link(containerShape, addedDomainModel);
//		
//		Shape shape = peCreateService.createShape(containerShape, false);
//		Text text = gaService.createText(shape, addedDomainModel.getName());
//		text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
//		setId(text, "test_id");
//		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
//		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
//		gaService.setLocationAndSize(text, 0, height/2-text_height/2, width, text_height);
//		
//		peCreateService.createChopboxAnchor(containerShape);

		
		Image page = gaService.createImage(containerShape, StructureViewImageProvider.PAGE_REF);
		gaService.setLocationAndSize(page, context.getX(), context.getY(), width, height);
		
		Shape shape = peCreateService.createShape(containerShape, false);
		Text text = gaService.createText(shape, addedDomainModel.getName());
		text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(text, 0, height/2-text_height/2, width, text_height);
		
		peCreateService.createChopboxAnchor(containerShape);
		
		link(containerShape, addedDomainModel);
		
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
		return mainBusinessObject instanceof Page;
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
