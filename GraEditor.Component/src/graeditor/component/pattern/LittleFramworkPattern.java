package graeditor.component.pattern;

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

import com.graeditor.component_model.Component_modelFactory;
import com.graeditor.component_model.DatabaseModule;
import com.graeditor.component_model.LittleFramworkModule;
import com.graeditor.component_model.LittleInterfaceModule;

import graeditor.component.graphiti.ComponentImageProvider;
import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;

public class LittleFramworkPattern extends IdPattern implements IPattern{
	
	private static IColorConstant FONT_COLOR = ColorConstant.BLACK;
	private static IColorConstant FILL_COLOR = ColorConstant.WHITE;
	
	public LittleFramworkPattern() {
		super();
	}
	
	@Override
	public String getCreateName() {
		return "Framwork";
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

		String ret = ExampleUtil.askString("Text", "Please input a text", "Framwork " + i);	
		try {
			value = ret;
		} catch (Exception e) {
		}
				
		System.out.println(getDiagram().getPictogramLinks().size());				
		
		LittleFramworkModule framworkModule = Component_modelFactory.eINSTANCE.createLittleFramworkModule();			
		framworkModule.setName("Framwork");
		framworkModule.setTextContent(value);
		getDiagram().eResource().getContents().add(framworkModule);
		addGraphicalRepresentation(context, framworkModule);
		return new Object[] { framworkModule };
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		System.out.println("canAdd");
		
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		LittleFramworkModule module = (LittleFramworkModule) context.getNewObject();
		Diagram diagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(diagram, true);
		
		GraPropertyUtil.setValue(containerShape, "shape_id", "Framwork"+IDGenerator.generateID());
		
		IGaService gaService = Graphiti.getGaService();
		
		int x = context.getX();
		int y = context.getY();
		
		int width = 200;
		int height = 200;
		int text_height = 10;
		
		GraphicsAlgorithm containerAlgorithm = null;
		
		containerAlgorithm = gaService.createRectangle(containerShape);
//		int xy[] = new int[] { 50, 0, 100, 100, 0, 100 };
//		containerAlgorithm = gaService.createPolygon(containerShape, xy);
		gaService.setLocationAndSize(containerAlgorithm, x, y, width, height);
		
		containerAlgorithm.setForeground(manageColor(FONT_COLOR));
		containerAlgorithm.setBackground(manageColor(FILL_COLOR));
		containerAlgorithm.setLineWidth(1);
		
				
		String text = null;
		
		text = "" + ((LittleFramworkModule)module).getTextContent();
		System.out.println(text);
		
		
		Shape shape = peCreateService.createShape(containerShape, false);
		Text textAlgorithm = gaService.createDefaultText(getDiagram(), shape, text);
		
		textAlgorithm.setHorizontalAlignment(Orientation.ALIGNMENT_TOP);

		textAlgorithm.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		textAlgorithm.setForeground(manageColor(FONT_COLOR));
		textAlgorithm.setFont(gaService.manageDefaultFont(getDiagram(), false, false));
		gaService.setLocationAndSize(textAlgorithm, 5, 5, width, 20);
		
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
		return mainBusinessObject instanceof LittleFramworkModule;
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
