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

import com.graeditor.flow_model.EndTagModule;
import com.graeditor.flow_model.Flow_modelFactory;
import com.graeditor.flow_model.PreLogInTagModule;

import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;

public class PreLogInTagPattern extends IdPattern implements IPattern{
	
	public PreLogInTagPattern() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public String getCreateName() {
		return "PreLogInTag";
	}
	
	@Override
	public boolean canCreate(ICreateContext context) {
		System.out.println("canCreate");		
		return context.getTargetContainer() instanceof Diagram;
	}
	
	@Override
	public Object[] create(ICreateContext context) {
		System.out.println("create");
		
		PreLogInTagModule logInTag = Flow_modelFactory.eINSTANCE.createPreLogInTagModule();
		logInTag.setName("PreLogInTag");
		getDiagram().eResource().getContents().add(logInTag);
		addGraphicalRepresentation(context, logInTag);
		return new Object[] { logInTag };		
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		System.out.println("canAdd");
		
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		PreLogInTagModule module = (PreLogInTagModule) context.getNewObject();
		Diagram diagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(diagram, true);
		
		GraPropertyUtil.setValue(containerShape, "shape_id", "PreLogInTag"+IDGenerator.generateID());
		
		IGaService gaService = Graphiti.getGaService();
		
		int x = context.getX();
		int y = context.getY();
		
		int range = 45;
		
		GraphicsAlgorithm containerAlgorithm = null;
		containerAlgorithm = gaService.createEllipse(containerShape);
		gaService.setLocationAndSize(containerAlgorithm, x, y, range, range);
		
		containerAlgorithm.setBackground(manageColor(187, 218, 247));
		
		peCreateService.createChopboxAnchor(containerShape);

		link(containerShape, module);
		
		return containerShape;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
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
		// TODO Auto-generated method stub
		return mainBusinessObject instanceof PreLogInTagModule;
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
