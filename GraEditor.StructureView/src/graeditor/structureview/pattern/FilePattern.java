package graeditor.structureview.pattern;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.Polygon;
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

import StructureView.File;
import StructureView.StructureViewFactory;
import graeditor.structureview.diagram.StructureViewImageProvider;
import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;

public class FilePattern extends IdPattern implements IPattern{
	private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant(98, 131, 167);
	private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant(187, 218, 247);
	private static final IColorConstant E_CLASS_WHITE = new ColorConstant(255, 255, 255);

	public FilePattern() {
		super();
	}
	
	@Override
	public String getCreateName() {
		return "File";
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	/* 
	 * 创建File实例
	 */
	@Override
	public Object[] create(ICreateContext context) {
		
		int i;
		i = getDiagram().getPictogramLinks().size() + 1;
		String ret = ExampleUtil.askString("Text", "Please input a text", "file" + i);
		String value = "s";
		try {
			value = ret;
		} catch (Exception e) {
		}
		File newfile = StructureViewFactory.eINSTANCE.createFile();
		newfile.setName(value);
		
		getDiagram().eResource().getContents().add(newfile);
		addGraphicalRepresentation(context, newfile);
		return new Object[] { newfile };
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		File addedDomainModel = (File) context.getNewObject();
		
		int width = 91;
		int height = 125;
		int l = 10;
		int text_height = 20;
		
		// 获取绘制图形的两种资源
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		GraPropertyUtil.setValue(containerShape, "shape_id", "File"+IDGenerator.generateID());
		
//		Rectangle outerRect = gaService.createInvisibleRectangle(containerShape);
//		gaService.setLocationAndSize(outerRect, context.getX(), context.getY(), context.getWidth(), context.getHeight());
//		
//		Rectangle rect1 = gaService.createRectangle(outerRect);
//		rect1.setForeground(manageColor(E_CLASS_FOREGROUND));
//		rect1.setBackground(manageColor(E_CLASS_BACKGROUND));
//		rect1.setLineWidth(2);
//		rect1.setFilled(true);
//		gaService.setLocationAndSize(rect1, 0, 0, width, height);
//		
//		// 文件右上角的遮罩层
//		Rectangle ghostRect = gaService.createRectangle(outerRect);
//		ghostRect.setBackground(manageColor(E_CLASS_WHITE));
//		ghostRect.setLineVisible(false);
//		ghostRect.setFilled(true);
//		gaService.setLocationAndSize(ghostRect, width-l, 0, l, l);
//		
//		Shape shape = peCreateService.createShape(containerShape, true);
//		int[] xy = new int[] { 0, 0, 0, l, l, l, 0, 0 };
//		Polygon corner = gaService.createPolygon(shape, xy);
//		corner.setFilled(true);
//		corner.setBackground(manageColor(E_CLASS_BACKGROUND));
//		gaService.setLocationAndSize(corner, width-l, 0, l, l);
		
		Image file = gaService.createImage(containerShape, StructureViewImageProvider.FILE_REF);
		gaService.setLocationAndSize(file, context.getX(), context.getY(), width, height);
		
		link(containerShape, addedDomainModel);
		
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
		return mainBusinessObject instanceof File;
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
