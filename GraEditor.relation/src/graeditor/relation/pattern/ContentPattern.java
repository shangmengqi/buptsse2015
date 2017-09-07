package graeditor.relation.pattern;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
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

import com.graeditor.relation_model.ContentModule;
import com.graeditor.relation_model.Relation_modelFactory;

import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;



public class ContentPattern extends IdPattern implements IPattern{
	
	private static IColorConstant FONT_COLOR = ColorConstant.BLACK;
	
	public ContentPattern() {
		super();
	}
	
	@Override
	public String getCreateName() {
		return "Content";
	}
	
	@Override
	public boolean canCreate(ICreateContext context) {		
		return context.getTargetContainer() instanceof Diagram;
	}
	
	@Override
	public Object[] create(ICreateContext context) {
		
		int i;
		i = getDiagram().getPictogramLinks().size() + 1;
		String ret = ExampleUtil.askString("Text", "Please input a text", "content" + i);
		String value = "s";
		try {
			value = ret;
		} catch (Exception e) {
		}
		ContentModule content = Relation_modelFactory.eINSTANCE.createContentModule();
		content.setName("Content");
		content.setTextContent(value);
		getDiagram().eResource().getContents().add(content);
		addGraphicalRepresentation(context, content);
		return new Object[] { content };		
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		ContentModule module = (ContentModule) context.getNewObject();
		Diagram diagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(diagram, true);
		
		GraPropertyUtil.setValue(containerShape, "shape_id", "Content"+IDGenerator.generateID());

		IGaService gaService = Graphiti.getGaService();
		
		int x = context.getX();
		int y = context.getY();
		
		int width = 180;
		int height = 60;
		
		GraphicsAlgorithm containerAlgorithm = null;
		containerAlgorithm = gaService.createRoundedRectangle(containerShape, 10, 10);
		gaService.setLocationAndSize(containerAlgorithm, x, y, width, height);
		
		containerAlgorithm.setForeground(manageColor(98, 131, 167));
		containerAlgorithm.setBackground(manageColor(187, 218, 247));
		containerAlgorithm.setLineWidth(2);
		
		//shape with text
		//����һ���µ�PictogramElement�����Ǹ�Ԫ�ز���һ������
		String text = null;
		
		text = "" + ((ContentModule)module).getTextContent();
		System.out.println(text);
		
		
		Shape shape = peCreateService.createShape(containerShape, false);
		//��Ԫ�ؼȲ��ǳ�����Ҳ������Բ���������֣�����ض�λ�����壬��ɫ��Ϣ����GraphicsAlgorithm����
		Text textAlgorithm = gaService.createDefaultText(getDiagram(), shape, text);
		
		textAlgorithm.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		textAlgorithm.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		textAlgorithm.setForeground(manageColor(FONT_COLOR));
		textAlgorithm.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
		gaService.setLocationAndSize(textAlgorithm, 5, 5, width, 50);
		
		peCreateService.createChopboxAnchor(containerShape);

		link(containerShape, module);
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
		return mainBusinessObject instanceof ContentModule;
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
