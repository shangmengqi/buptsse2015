package graeditor.flow.pattern;

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

import com.graeditor.flow_model.Flow_modelFactory;
import com.graeditor.flow_model.VerticalLineModule;


public class VerticalLinePattern extends IdPattern implements IPattern{
	
	public VerticalLinePattern() {
		super();
	}
	
	@Override
	public String getCreateName() {
		return "VerticalLine";
	}
	
	@Override
	public boolean canCreate(ICreateContext context) {
		
		return context.getTargetContainer() instanceof Diagram;
	}
	
	@Override
	public Object[] create(ICreateContext context) {
		VerticalLineModule verticalLine = Flow_modelFactory.eINSTANCE.createVerticalLineModule();
		verticalLine.setName("VerticalLine");
		getDiagram().eResource().getContents().add(verticalLine);
		addGraphicalRepresentation(context, verticalLine);
		return new Object[] { verticalLine };					
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		
		VerticalLineModule module = (VerticalLineModule) context.getNewObject();
		Diagram diagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(diagram, true);
		
		IGaService gaService = Graphiti.getGaService();
		
		int width = 3;
		int height = 600;
		int x = context.getX();
		int y = context.getY();		
		
//		Image file = gaService.createImage(containerShape, FlowImageProvider.VERTICAL_LINE);
//		System.out.println(file);
//		System.out.println(FlowImageProvider.VERTICAL_LINE);
//		
//		gaService.setLocationAndSize(file, x, y, width, height);
		
		GraphicsAlgorithm containerAlgorithm = null;
		containerAlgorithm = gaService.createPlainRectangle(containerShape);
		gaService.setLocationAndSize(containerAlgorithm, x, y, width, height);
		
		containerAlgorithm.setBackground(manageColor(187, 218, 247));
		containerAlgorithm.setLineVisible(false);
		
		link(containerShape, module);
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
		return mainBusinessObject instanceof VerticalLineModule;
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
