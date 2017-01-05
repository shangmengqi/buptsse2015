package graeditor.flowview.pattern;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
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
import FlowView.View;
import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;
import graeditor.utils.ValueUtil;

public class ViewPattern extends IdPattern implements IPattern{
	private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant(198, 131, 104);
	private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant(56, 218, 247);
	private static final IColorConstant E_CLASS_WHITE = new ColorConstant(255, 255, 255);
	
	public ViewPattern() {
		super();
	}
	
	@Override
	public String getCreateName() {
		return "View";
	}

	/* 
	 * canCreate函数是实时进行判断的
	 * View的添加需要判断它的容器，区别于容器为Diagram，它需要放在一个Function中
	 */
	@Override
	public boolean canCreate(ICreateContext context) {
		Function func = getFunction(context);
		if (func != null) { // 可能还需要额外的判断
			return true;
		} else {
			View view = getView(context);
			if (view != null) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param context
	 * @return
	 */
	private Function getFunction(ICreateContext context) {
		ContainerShape targetContainer = context.getTargetContainer();
		Object func = getBusinessObjectForPictogramElement(targetContainer);
		
		if (func instanceof Function) {
			return (Function)func;
		}
		
		return null;
	}
	
	private View getView(ICreateContext context) {
		ContainerShape targetContainer = context.getTargetContainer();
		Object view = getBusinessObjectForPictogramElement(targetContainer);
		
		if (view instanceof View) {
			return (View)view;
		}
		
		return null;
	}

	@Override
	public Object[] create(ICreateContext context) {
		View newView = FlowViewFactory.eINSTANCE.createView();
		newView.setName("newView");
		
		// TODO 可能需要修改的地方
		getDiagram().eResource().getContents().add(newView);
		addGraphicalRepresentation(context, newView);
		return new Object[] { newView };
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context) && context.getTargetContainer() instanceof ContainerShape;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		// 在一个图形元素内部创建另外一个图形元素时，需要重新创建一个ContainerShape，否则会让原有的图形元素消失
		// 此处区别于其他的Diagram
		ContainerShape parrent = (ContainerShape) context.getTargetContainer();
		ContainerShape outerParrent = parrent; // 外层的Function容器，因为parrent有可能是View，因此需要获取outerParrent
		EList<Property> properties = outerParrent.getProperties();
		for (int i = 0; i < properties.size(); i++) {
			if (properties.get(i).getKey().equals(ValueUtil.SHAPE_ID)){ // 当属性为shape_id时
				if (!properties.get(i).getValue().startsWith(ValueUtil.FLOWVIEW_FUNCTION)) { // 不是以function开头的value，那么需要将outerParrent设为parrent的父容器
					outerParrent = outerParrent.getContainer();
				}
				break;
			}
		}
		View addedDomainModel = (View) context.getNewObject();
		
		
		// 获取绘制图形的两种资源
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		
		EList<Shape> allChildren = outerParrent.getChildren();
		// 获取所有原有的View
		List<Integer> childrenIndex = new ArrayList<Integer>();
		// 不是所有的孩子都是View，还有outerParrent的两条线段
		for (int i = 0; i < allChildren.size(); i++) {
			EList<Property> p = allChildren.get(i).getProperties(); // 只取出其中的View
			for (int j = 0; j < p.size(); j++) {
				if (p.get(j).getKey().equals(ValueUtil.SHAPE_ID)) {
					if (p.get(j).getValue().startsWith(ValueUtil.FLOWVIEW_VIEW)) {
						childrenIndex.add(Integer.valueOf(i));
						// ------------------- 此处改为使用一个Integer的列表来存储下标，而不是直接存是节点的孩子。因为EList的add如果是从另一个EList里取出来的，会从另一个EList里删掉这个对象再存。见杂项文档的第二条
					}
				}
			}
		}
		int count = childrenIndex.size();
		
		// TODO 计算当前的children的插入点
		int x = context.getX();
		int w = parrent.getGraphicsAlgorithm().getWidth();
//		int pw = outerParrent.getGraphicsAlgorithm().getWidth();
		boolean isFirstHalf = x <= w/2 ? true : false; // 用于判断插入点是否是在View的左半边，如果不是在View中，则无差别
		
		// 计算outerParrent的新宽度
		int newWidth = (++count) * ValueUtil.FLOWVIEW_VIEW_WIDTH + ValueUtil.TEXT_HEIGHT;
		// 设置outerParrent的宽度
		outerParrent.getGraphicsAlgorithm().setWidth(newWidth);
		// 用于设置每个View的新起点
		int offset = 0;
		// 新View的插入点
		int newX = 0;
		for (int i = 0; i < count-1; i++) {
			
			if (parrent == allChildren.get(childrenIndex.get(i))) { // 当前这个View是点击插入的View
				if (isFirstHalf) {  // 左半段，插入点在当前parrent左边
					newX = ValueUtil.FLOWVIEW_VIEW_WIDTH * (i); // 先设置新View的插入点，再设置后续的X
					offset = 1;
					parrent.getGraphicsAlgorithm().setX(ValueUtil.FLOWVIEW_VIEW_WIDTH * (i + offset) + ValueUtil.TEXT_HEIGHT);
					
					//gaService.setLocationAndSize(children.get(i).getGraphicsAlgorithm(), ValueUtil.FLOWVIEW_VIEW_WIDTH * (i + offset), children.get(i).getGraphicsAlgorithm().getY(), children.get(i).getGraphicsAlgorithm().getWidth(), children.get(i).getGraphicsAlgorithm().getHeight());
				} else { // 右半段，插入点在当前parrent右边
					parrent.getGraphicsAlgorithm().setX(ValueUtil.FLOWVIEW_VIEW_WIDTH * (i) + ValueUtil.TEXT_HEIGHT); // 先设置后续的X，再设置新View的插入点
					offset = 1;
					newX = ValueUtil.FLOWVIEW_VIEW_WIDTH * (i + offset);
				}
			} else {
				allChildren.get(childrenIndex.get(i)).getGraphicsAlgorithm().setX(ValueUtil.FLOWVIEW_VIEW_WIDTH * (i + offset) + ValueUtil.TEXT_HEIGHT); // 设置每个孩子的新起点 
			}
		}
		
		
		// TODO 重新调整所有的View
		
		// 重新创建本图形的containerShape
		ContainerShape containerShape = peCreateService.createContainerShape(outerParrent, true);
		// 添加ID
		GraPropertyUtil.setValue(containerShape, ValueUtil.SHAPE_ID, ValueUtil.FLOWVIEW_VIEW+IDGenerator.generateID());
		
		Rectangle rect = gaService.createRectangle(containerShape);
		rect.setForeground(manageColor(E_CLASS_FOREGROUND));
		rect.setBackground(manageColor(E_CLASS_WHITE));
		gaService.setLocationAndSize(rect, ValueUtil.TEXT_HEIGHT + newX, ValueUtil.TEXT_HEIGHT, ValueUtil.FLOWVIEW_VIEW_WIDTH, outerParrent.getGraphicsAlgorithm().getHeight()-ValueUtil.TEXT_HEIGHT-2);
		//gaService.setLocationAndSize(rect, ValueUtil.TEXT_HEIGHT + newX, ValueUtil.TEXT_HEIGHT, ValueUtil.FLOWVIEW_VIEW_WIDTH, outerParrent.getGraphicsAlgorithm().getHeight()-ValueUtil.TEXT_HEIGHT-2);
		
		// 创建横线
		final Shape horizontalLineShape = peCreateService.createShape(containerShape, false);
		final Polyline horizontalPolyline = gaService.createPlainPolyline(horizontalLineShape, new int[] { 0, ValueUtil.TEXT_HEIGHT, outerParrent.getGraphicsAlgorithm().getWidth()-ValueUtil.TEXT_HEIGHT, ValueUtil.TEXT_HEIGHT });
				
		
		link(containerShape, addedDomainModel);
		
//		return containerShape;
		return outerParrent;
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
		return mainBusinessObject instanceof View;
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
