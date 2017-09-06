package graeditor.flow.pattern;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
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
import org.eclipse.ui.part.MultiEditor.Gradient;

import com.graeditor.flow_model.Flow;
import com.graeditor.flow_model.FlowModule;
import com.graeditor.flow_model.Flow_modelFactory;
import com.graeditor.flow_model.StartTagModule;

import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;


public class StartTagPattern extends IdPattern implements IPattern{
	
	private static IColorConstant FONT_COLOR = ColorConstant.BLACK;
	
	public StartTagPattern() {
		super();
	}
	
	@Override
	public String getCreateName() {
		return "StartTag";
	}
	
	@Override
	public boolean canCreate(ICreateContext context) {
		
		return context.getTargetContainer() instanceof Diagram;
	}
	
	@Override
	public Object[] create(ICreateContext context) {
		
		int i;
		i = getDiagram().getPictogramLinks().size() + 1;
		String ret = ExampleUtil.askString("Text", "Please input a text", "startTag" + i);
		String value = "s";
		try {
			value = ret;
		} catch (Exception e) {
		}
		StartTagModule startTag = Flow_modelFactory.eINSTANCE.createStartTagModule();
		startTag.setName("StartTag");
		startTag.setTextContent(value);
		getDiagram().eResource().getContents().add(startTag);
		addGraphicalRepresentation(context, startTag);
		return new Object[] { startTag };		
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}
	
	@Override
	protected PictogramElement doAdd(IAddContext context) {
		
		StartTagModule module = (StartTagModule) context.getNewObject();
		Diagram diagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(diagram, true);
		
		GraPropertyUtil.setValue(containerShape, "shape_id", "StartTag"+IDGenerator.generateID());
		
		IGaService gaService = Graphiti.getGaService();
		
		int x = context.getX();
		int y = context.getY();
		
		int width = 100;
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
		
		text = "" + ((StartTagModule)module).getTextContent();
		System.out.println(text);
		
		
		Shape shape = peCreateService.createShape(containerShape, false);
		//��Ԫ�ؼȲ��ǳ�����Ҳ������Բ���������֣�����ض�λ�����壬��ɫ��Ϣ����GraphicsAlgorithm����
		Text textAlgorithm = gaService.createDefaultText(getDiagram(), shape, text);
		
		textAlgorithm.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		textAlgorithm.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		textAlgorithm.setForeground(manageColor(FONT_COLOR));
		textAlgorithm.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
		gaService.setLocationAndSize(textAlgorithm, 5, 5, width, 20);
		
		//shape with line
		Shape shape1 = peCreateService.createShape(containerShape, false);
		Polyline polyline = gaService.createPolyline(shape1, new int[]{0,30,width,30});
		polyline.setForeground(manageColor(98, 131, 167));
		polyline.setLineWidth(2);
		
		//��������㽨ê����Ϊ��ê���ܴ���connection����ȻԪ��֮�����໥����������
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
		return mainBusinessObject instanceof StartTagModule;
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
