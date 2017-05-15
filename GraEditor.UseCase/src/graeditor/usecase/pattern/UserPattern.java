package graeditor.usecase.pattern;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
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

import graeditor.usecase.provider.UseCaseImageProvider;
import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;
import usecase.UsecaseFactory;
import usecase.User;

public class UserPattern extends IdPattern implements IPattern{
	private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant(98, 131, 167);
	private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant(187, 218, 247);
	
	
	public UserPattern() {
		super();
	}

	/* 
	 * 显示在Objects列表中的名字
	 */
	@Override
	public String getCreateName() {
		return "User";
	}

	/* 
	 * 用于判断User能否添加，只有context为Diagram中才能添加
	 */
	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	/* 
	 * 创建一个user实例
	 */
	@Override
	public Object[] create(ICreateContext context) {
		
		int i;
		i = getDiagram().getPictogramLinks().size() + 1;
		String ret = ExampleUtil.askString("Text", "Please input a text", "newUser" + i);
		String value = "s";
		try {
			value = ret;
		} catch (Exception e) {
		}
		
		User newUser = UsecaseFactory.eINSTANCE.createUser();
		newUser.setName(value);
		
		getDiagram().eResource().getContents().add(newUser);
		addGraphicalRepresentation(context, newUser);
		return new Object[] { newUser };
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
//		return true;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		User addedDomainModel = (User) context.getNewObject();
		
		// 获取绘制图形的两种资源
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		
		int height = 140;
		int width = 60;
		int text_height = 20;
		int outer_height = 170;
		
//		int x = 20;
//		int y = 40;
//		int l = 20;
//		int m = l / 2;
		
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		GraPropertyUtil.setValue(containerShape, "shape_id", "User"+IDGenerator.generateID());
		
//		// 创建小人的身体
//		Rectangle invisibleRectangle = gaService.createInvisibleRectangle(containerShape);
//		gaService.setLocationAndSize(invisibleRectangle, context.getX(), context.getY(), width, y+2*l+m+20);
//		
//		Shape shape = peCreateService.createShape(containerShape, true);
//		int body_point[] = new int[] { x, y, x, y+m, x-m, y+2*m, x, y+m, x+m, y+2*m, x, y+m, x, y+l+m, x-m, y+2*m+l, x, y+l+m, x+m, y+2*m+l, x, y+l+m};
//		Polygon body = gaService.createPolygon(shape, body_point);
//		body.setLineWidth(2);
//		gaService.setLocationAndSize(body, 0, 0, m*2, l*2+m);
//		
//		
//		// 创建小人头部
//		Ellipse ellipse = gaService.createEllipse(invisibleRectangle);
//		ellipse.setBackground(manageColor(E_CLASS_BACKGROUND));
//		gaService.setLocationAndSize(ellipse, 0, 0, width, height);
		
		/////////////////////////////////////
		
		Image user = gaService.createImage(containerShape, UseCaseImageProvider.USER_REF);
		gaService.setLocationAndSize(user, context.getX(), context.getY(), width, outer_height);
		
		/////////////////////////////////////
		
		
		// SHAPE WITH TEXT
        {
            // create shape for text
            Shape shape_text = peCreateService.createShape(containerShape, false);
 
            // create and set text graphics algorithm
            Text text = gaService.createText(shape_text, addedDomainModel.getName());
            text.setForeground(manageColor(E_CLASS_FOREGROUND));
            text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER ); 
            // vertical alignment has as default value "center"
            text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
            gaService.setLocationAndSize(text, 0, height+text_height/2, width, text_height);
 
            // create link and wire it
//            link(shape_text, addedDomainModel);
        }
		
        // 创建锚点
        peCreateService.createChopboxAnchor(containerShape);
        
        link(containerShape, addedDomainModel);
        
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
		return mainBusinessObject instanceof User;
	}

	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		Object domainObject  = getBusinessObjectForPictogramElement(pictogramElement);
		return isMainBusinessObjectApplicable(domainObject);
	}

	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object domainObject = getBusinessObjectForPictogramElement(pictogramElement);
	    return isMainBusinessObjectApplicable(domainObject);
	}

}
