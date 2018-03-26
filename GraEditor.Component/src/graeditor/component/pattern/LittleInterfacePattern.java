package graeditor.component.pattern;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.pattern.id.IdPattern;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import com.graeditor.component_model.ComponentModule;
import com.graeditor.component_model.Component_modelFactory;
import com.graeditor.component_model.LittleInterfaceModule;

import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;


public class LittleInterfacePattern extends IdPattern implements IPattern{
	
	private static IColorConstant FONT_COLOR = ColorConstant.BLACK;
	private static IColorConstant FILL_COLOR = ColorConstant.WHITE;
	
	public LittleInterfacePattern() {
		super();
	}
	
	@Override
	public String getCreateName() {
		return "Interface";
	}
	
	@Override
	public boolean canCreate(ICreateContext context) {
		
		return context.getTargetContainer() instanceof Diagram;
	}
	
	@Override
	public Object[] create(ICreateContext context) {
		
				
		System.out.println(getDiagram().getPictogramLinks().size());				
		
		LittleInterfaceModule interfaceModule = Component_modelFactory.eINSTANCE.createLittleInterfaceModule();			
		interfaceModule.setName("Interface");
		getDiagram().eResource().getContents().add(interfaceModule);
		addGraphicalRepresentation(context, interfaceModule);
		return new Object[] { interfaceModule };
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		System.out.println("canAdd");
		
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}


	@Override
	protected PictogramElement doAdd(IAddContext context) {
		System.out.println("doAdd");
		LittleInterfaceModule module = (LittleInterfaceModule) context.getNewObject();
		Diagram diagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(diagram, true);
		
		GraPropertyUtil.setValue(containerShape, "shape_id", "Interface"+IDGenerator.generateID());
		
		IGaService gaService = Graphiti.getGaService();
		
		int x = context.getX();
		int y = context.getY();
		
		int range = 25;
		
		GraphicsAlgorithm containerAlgorithm = null;
		containerAlgorithm = gaService.createEllipse(containerShape);
		gaService.setLocationAndSize(containerAlgorithm, x, y, range, range);
		
		containerAlgorithm.setForeground(manageColor(FONT_COLOR));
		containerAlgorithm.setBackground(manageColor(FILL_COLOR));
		containerAlgorithm.setLineWidth(1);
		
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
		return mainBusinessObject instanceof LittleInterfaceModule;
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
