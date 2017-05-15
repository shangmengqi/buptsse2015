package graeditor.structureview.pattern;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
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

import StructureView.FileGroup;
import StructureView.StructureViewFactory;

import graeditor.structureview.diagram.StructureViewImageProvider;
import graeditor.utils.GraPropertyUtil;
import graeditor.utils.IDGenerator;

public class FileGroupPattern extends IdPattern implements IPattern{
	public FileGroupPattern() {
		super();
	}

	@Override
	public String getCreateName() {
		return "FileGroup";
	}

	/* 
	 * 判断是否能创建FileGroup
	 */
	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	/* 
	 * 创建一个FileGroup实例
	 */
	@Override
	public Object[] create(ICreateContext context) {
		
		int i;
		i = getDiagram().getPictogramLinks().size() + 1;
		String ret = ExampleUtil.askString("Text", "Please input a text", "FileGroup" + i);
		String value = "s";
		try {
			value = ret;
		} catch (Exception e) {
		}
		FileGroup newFileGroup = StructureViewFactory.eINSTANCE.createFileGroup();
		newFileGroup.setName(value);
		getDiagram().eResource().getContents().add(newFileGroup);
		addGraphicalRepresentation(context, newFileGroup);
		return new Object[] { newFileGroup };
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		FileGroup addedDomainModel = (FileGroup) context.getNewObject();
		
		int width = 100;
		int height = 132;
		int text_height = 20;
		
		// 获取绘制图形的两种资源
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		GraPropertyUtil.setValue(containerShape, "shape_id", "FileGroup"+IDGenerator.generateID());
		
		Image file = gaService.createImage(containerShape, StructureViewImageProvider.FILEGROUP_REF);
		gaService.setLocationAndSize(file, context.getX(), context.getY(), width, height);
		System.out.println(file);
		System.out.println(StructureViewImageProvider.FILEGROUP_REF);
		
		
		link(containerShape, addedDomainModel);
		
		Shape shape = peCreateService.createShape(containerShape, false);
		Text text = gaService.createText(shape, addedDomainModel.getName());
		text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(text, 0, height/2-text_height/2, width, text_height);
		
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
		return mainBusinessObject instanceof FileGroup;
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
