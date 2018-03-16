package graeditor.flow.pattern;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Image;
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

import com.graeditor.flow_model.ControlTagModule;
import com.graeditor.flow_model.EndTagModule;
import com.graeditor.flow_model.FenChaModule;
import com.graeditor.flow_model.Flow_modelFactory;

import graeditor.flow.graphiti.FlowImageProvider;
import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;

public class FenChaPattern extends IdPattern implements IPattern{
	
	public FenChaPattern() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public String getCreateName() {
		return "FenCha";
	}
	
	@Override
	public boolean canCreate(ICreateContext context) {
		
		return context.getTargetContainer() instanceof Diagram;
	}
	
	@Override
	public Object[] create(ICreateContext context) {
		
		FenChaModule fenChaModule = Flow_modelFactory.eINSTANCE.createFenChaModule();			
		fenChaModule.setName("FenCha");
		getDiagram().eResource().getContents().add(fenChaModule);
		addGraphicalRepresentation(context, fenChaModule);
		return new Object[] { fenChaModule };
	}
	
	@Override
	public boolean canAdd(IAddContext context) {
		System.out.println("canAdd");
		
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		// TODO Auto-generated method stub
		
		FenChaModule module = (FenChaModule) context.getNewObject();
		Diagram diagram = (Diagram) context.getTargetContainer();
		
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape = peCreateService.createContainerShape(diagram, true);
		
		GraPropertyUtil.setValue(containerShape, "shape_id", "FenCha"+IDGenerator.generateID());
		
		IGaService gaService = Graphiti.getGaService();
		
		int x = context.getX();
		int y = context.getY();
		
		int width = 20;
		int height = 120;
		
		
		GraphicsAlgorithm containerAlgorithm = null;
//		Image file = gaService.createImage(containerShape, FlowImageProvider.FENCHA);
		containerAlgorithm = gaService.createPlainRectangle(containerShape);
//		containerAlgorithm = gaService.createInvisibleRectangle(containerShape);
//		gaService.setLocationAndSize(file, context.getX(), context.getY(), width, height);
		gaService.setLocationAndSize(containerAlgorithm, x, y, width, height);
		
		containerAlgorithm.setForeground(manageColor(98, 131, 167));
//		containerAlgorithm.setBackground(manageColor(187, 218, 247));
//		containerAlgorithm.setLineWidth(5);
		
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
		return mainBusinessObject instanceof FenChaModule;
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
