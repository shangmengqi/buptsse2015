package graeditor.flow.pattern;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
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

import com.graeditor.flow_model.ContentModule;
import com.graeditor.flow_model.ControlTagModule;
import com.graeditor.flow_model.EndTagModule;
import com.graeditor.flow_model.Flow_modelFactory;
import com.graeditor.flow_model.PreLogInTagModule;

import graeditor.flow.graphiti.FlowImageProvider;
import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;

public class ControlTagPattern extends IdPattern implements IPattern{
	
	private static IColorConstant FONT_COLOR = ColorConstant.BLACK;
	
	public ControlTagPattern() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public String getCreateName() {
		return "ControlTag";
	}
	
	@Override
	public boolean canCreate(ICreateContext context) {
		
		return context.getTargetContainer() instanceof Diagram;
	}
	
	@Override
	public Object[] create(ICreateContext context) {
		
		String value = null ;
		int i;
						
		System.out.println(getDiagram().getPictogramLinks().size());		
		i = getDiagram().getPictogramLinks().size() + 1;

		String ret = ExampleUtil.askString("Text", "Please input a text", "if " + i);	
		try {
			value = ret;
		} catch (Exception e) {
		}
		
		ControlTagModule controlTag = Flow_modelFactory.eINSTANCE.createControlTagModule();			
		controlTag.setName("ControlTag");
		controlTag.setTextContent(value);
		getDiagram().eResource().getContents().add(controlTag);
		addGraphicalRepresentation(context, controlTag);
		return new Object[] { controlTag };
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		ControlTagModule module = (ControlTagModule) context.getNewObject();
		Diagram diagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(diagram, true);
		
		GraPropertyUtil.setValue(containerShape, "shape_id", "ControlTag"+IDGenerator.generateID());
		
		IGaService gaService = Graphiti.getGaService();
		
		int x = context.getX();
		int y = context.getY();
		
		int width = 100;
		int height = 50;
		int text_height = 10;
		
		GraphicsAlgorithm containerAlgorithm = null;
		
		Image file = gaService.createImage(containerShape, FlowImageProvider.CONTROL);
		gaService.setLocationAndSize(file, context.getX(), context.getY(), width, height);
				
		String text = null;
		
		text = "" + ((ControlTagModule)module).getTextContent();
		System.out.println(text);
		
		
		Shape shape = peCreateService.createShape(containerShape, false);
		//��Ԫ�ؼȲ��ǳ�����Ҳ������Բ���������֣�����ض�λ�����壬��ɫ��Ϣ����GraphicsAlgorithm����
		Text textAlgorithm = gaService.createDefaultText(getDiagram(), shape, text);
		
		textAlgorithm.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		textAlgorithm.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		textAlgorithm.setForeground(manageColor(FONT_COLOR));
		textAlgorithm.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
		gaService.setLocationAndSize(textAlgorithm, 2, 2, width, height);
		
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
		// TODO Auto-generated method stub
		return mainBusinessObject instanceof ControlTagModule;
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
