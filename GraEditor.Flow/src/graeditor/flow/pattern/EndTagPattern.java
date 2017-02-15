package graeditor.flow.pattern;

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

import com.graeditor.flow_model.EndTagModule;
import com.graeditor.flow_model.Flow_modelFactory;
import com.graeditor.flow_model.StartTagModule;

public class EndTagPattern extends IdPattern implements IPattern{
	
	public EndTagPattern() {
		super();
	}
	
	@Override
	public String getCreateName() {
		return "EndTag";
	}
	
	@Override
	public boolean canCreate(ICreateContext context) {
		System.out.println("canCreate");
		
		return context.getTargetContainer() instanceof Diagram;
	}
	
	@Override
	public Object[] create(ICreateContext context) {
		System.out.println("create");
		
		EndTagModule endTag = Flow_modelFactory.eINSTANCE.createEndTagModule();
		endTag.setName("EndTag");
		getDiagram().eResource().getContents().add(endTag);
		addGraphicalRepresentation(context, endTag);
		return new Object[] { endTag };		
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		System.out.println("canAdd");
		
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		System.out.println("doAdd");
		EndTagModule module = (EndTagModule) context.getNewObject();
		Diagram diagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(diagram, true);
		
		IGaService gaService = Graphiti.getGaService();
		
		int x = context.getX();
		int y = context.getY();
		
		int range = 50;
		
		GraphicsAlgorithm containerAlgorithm = null;
		containerAlgorithm = gaService.createEllipse(containerShape);
		gaService.setLocationAndSize(containerAlgorithm, x, y, range, range);
		
		containerAlgorithm.setForeground(manageColor(98, 131, 167));
		containerAlgorithm.setBackground(manageColor(187, 218, 247));
		containerAlgorithm.setLineWidth(5);
		
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
		return mainBusinessObject instanceof EndTagModule;
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
