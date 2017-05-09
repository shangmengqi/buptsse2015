package graeditor.usecase.features;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.internal.Messages;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;

import graeditor.utils.DiagramUtil;
import usecase.UsercaseModule;
import xml.utils.addLinkToXML;

public class AssociateDiagramFeature extends AbstractCustomFeature{

	public AssociateDiagramFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
    public String getName() {
        return "Associate diagram";
    }
 
    @Override
    public String getDescription() {
        return "Associate the diagram with this EClass";
    }
    
    @Override
    public boolean canExecute(ICustomContext context) {
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length >= 1) {
            ret = true;
        }
        return ret;
    }

	@Override
	public void execute(ICustomContext context) {
		int objectNum = 0;
		String currentDiagramName = null;
		final Diagram currentDiagram = getDiagram();//currentDiagram为当前要进行跳转的图表
		final PictogramElement pe = context.getPictogramElements()[0]; //获取当前被选择的元素
		
		// TODO 关联的处理函数，此处应该是获取所有的图表，让用户选择一个，
		final Collection<Diagram> ret = new HashSet<Diagram>();
		final Collection<Diagram> allDiagrams = getDiagrams();
		
//		PictogramElement[] pes = context.getPictogramElements();
//		UsercaseModule module[] = new UsercaseModule[pes.length];
//		for (int i = 0; i < module.length; i++) {
//			module[i] = (UsercaseModule) getBusinessObjectForPictogramElement(pes[i]);
////			objectNum = i + 1;
//		}
		
		for (int i = 0; i < currentDiagram.getChildren().size(); i++) {
			if (currentDiagram.getChildren().get(i).equals(pe)) {
				objectNum = i + 1;
				System.out.println("objectNum: " + objectNum);
			}
		}				
		
		for (final Diagram d : allDiagrams) {
//			System.out.println("currentDiagramName: " + currentDiagram.getName());
			currentDiagramName = currentDiagram.getName();			
			if (!EcoreUtil.equals(currentDiagram, d)) { // always filter out the														// current
				ret.add(d);							
			}
		}
				
		
		Diagram diagram = null;
		if (!ret.isEmpty()) {
			final Diagram[] possibleDiagrams = ret.toArray(new Diagram[0]);
			if (ret.size() == 1) {
				diagram = possibleDiagrams[0];
			} else {
				ListDialog dialog = new ListDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
				dialog.setContentProvider(new IStructuredContentProvider() {
					public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
					}
					public void dispose() {
					}
					public Object[] getElements(Object inputElement) {
						return ret.toArray();
					}
				});
				dialog.setTitle(Messages.AbstractDrillDownFeature_1_xmsg);
				dialog.setMessage(Messages.AbstractDrillDownFeature_2_xmsg);
				dialog.setInitialSelections(new Diagram[] { possibleDiagrams[0] });
				dialog.setLabelProvider(new DiagramLabelProvider());
				dialog.setAddCancelButton(true);
				dialog.setHelpAvailable(false);
				dialog.setInput(new Object());
				dialog.open();
				Object[] result = dialog.getResult();
				if (result != null) {
					for (int i = 0; i < result.length; i++) {
						diagram = (Diagram) result[i];
						
					}
				}
			}

			if (diagram != null) {				
				String diagramName = diagram.getName();
				System.out.println("diagramName : " + diagramName);
				//进行测试根据文件名获取该文件的绝对路径	
				String filePath = DiagramUtil.getFilePath(diagram);								
				addLinkToXML.addLink(filePath,currentDiagramName,objectNum);
				System.out.println("haha : ");								
			}
		}
	}
	
	protected Collection<Diagram> getDiagrams() {
		Collection<Diagram> result = Collections.emptyList();
		Resource resource = getDiagram().eResource();
		URI uri = resource.getURI();
		URI uriTrimmed = uri.trimFragment();
		if (uriTrimmed.isPlatformResource()) {
			String platformString = uriTrimmed.toPlatformString(true);
			IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (fileResource != null) {
				IProject project = fileResource.getProject();
				System.out.println("project: " + project);
				result = DiagramUtil.getDiagrams(project);
				System.out.println("result: " + result);
			}
		}
		return result;//result返回编辑器上同一个项目下所有的diagram图表信息，包括图表名称，并将这些diagram存在一个数组里
	}
	
	private class DiagramLabelProvider extends LabelProvider {

		Image image;

		/**
		 * Instantiates a new diagram label provider.
		 */
		public DiagramLabelProvider() {
			super();
		}

		@Override
		public String getText(Object o) {
			String ret = null;
			if (o instanceof Diagram) {
				Diagram diagram = (Diagram) o;
				ret = diagram.getName() + " (" + diagram.getDiagramTypeId() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
			}
			return ret;
		}

		@Override
		public Image getImage(Object element) {
			if (this.image == null) {
				this.image = GraphitiUi.getImageService().getPlatformImageForId(
						IPlatformImageConstants.IMG_DIAGRAM);
			}
			return this.image;
		}

	}

}
