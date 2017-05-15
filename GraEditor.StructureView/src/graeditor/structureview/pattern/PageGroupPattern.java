package graeditor.structureview.pattern;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
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

import StructureView.PageGroup;
import StructureView.StructureViewFactory;
import graeditor.structureview.diagram.StructureViewImageProvider;
import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;

public class PageGroupPattern extends IdPattern implements IPattern{
	private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant(98, 131, 167);
	private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant(187, 218, 247);
	
	public PageGroupPattern() {
		super();
	}

	@Override
	public String getCreateName() {
		return "PageGroup";
	}

	/* 
	 * 判断PageGroup能否添加
	 */
	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}


	/**
	 * 创建一个PageGroup实例
	 * @param context
	 * @return
	 */
	@Override
	public Object[] create(ICreateContext context) {
		
		int i;
		i = getDiagram().getPictogramLinks().size() + 1;
		String ret = ExampleUtil.askString("Text", "Please input a text", "PageGroup" + i);
		String value = "s";
		try {
			value = ret;
		} catch (Exception e) {
		}
		PageGroup newPageGroup = StructureViewFactory.eINSTANCE.createPageGroup();
		newPageGroup.setName(value);
		
		getDiagram().eResource().getContents().add(newPageGroup);
		addGraphicalRepresentation(context, newPageGroup);
		return new Object[] { newPageGroup };
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		PageGroup addedDomainModel = (PageGroup) context.getNewObject();
		
		int width = 160;
		int height = 110;
		int text_height = 20;
		int offset = 10;
		
		// 获取绘制图形的两种资源
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		GraPropertyUtil.setValue(containerShape, "shape_id", "PageGroup"+IDGenerator.generateID());
		
//		// 创建遮罩层，要义在于宽高的设置，还有其中包含的元素的创建方法、设置的起始位置
//		Rectangle ghostRect = gaService.createInvisibleRectangle(containerShape);
//		gaService.setLocationAndSize(ghostRect, context.getX(), context.getY(), context.getWidth(), context.getHeight());
//		
//		Rectangle rect1 = gaService.createRectangle(ghostRect);
//		rect1.setForeground(manageColor(E_CLASS_FOREGROUND));
//		rect1.setBackground(manageColor(E_CLASS_BACKGROUND));
//		rect1.setLineWidth(2);
//		rect1.setFilled(true);
//		gaService.setLocationAndSize(rect1, offset, offset, width, height);
//		
//		Rectangle rect2 = gaService.createRectangle(ghostRect);
//		rect2.setForeground(manageColor(E_CLASS_FOREGROUND));
//		rect2.setBackground(manageColor(E_CLASS_BACKGROUND));
//		rect2.setLineWidth(2);
//		rect2.setFilled(true);
//		gaService.setLocationAndSize(rect2, 0, 0, width, height);
		
		Image page = gaService.createImage(containerShape, StructureViewImageProvider.PAGEGROUP_REF);
		gaService.setLocationAndSize(page, context.getX(), context.getY(), width, height);
		
		link(containerShape, addedDomainModel);
		
		////// 以下是创建text
		
		Shape shape = peCreateService.createShape(containerShape, false);
		Text text = gaService.createText(shape, addedDomainModel.getName());
		text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(text, 0, height/2-text_height/2, width, text_height);
		
		peCreateService.createChopboxAnchor(containerShape);
		
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

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof PageGroup;
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
