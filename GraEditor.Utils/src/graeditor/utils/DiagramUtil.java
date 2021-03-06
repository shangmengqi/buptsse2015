package graeditor.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.algorithms.impl.ImageImpl;
import org.eclipse.graphiti.mm.algorithms.impl.TextImpl;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.internal.services.GraphitiUiInternal;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.internal.Workbench;

import xml.utils.constant;

public class DiagramUtil {
	
	
	
	public static Collection<Diagram> getDiagrams(IProject p) {
		final List<IFile> files = getDiagramFiles(p);
		final List<Diagram> diagramList = new ArrayList<Diagram>();
		final ResourceSet rSet = new ResourceSetImpl();
		for (final IFile file : files) {
			final Diagram diagram = getDiagramFromFile(file, rSet);
			if (diagram != null) {
				diagramList.add(diagram);
			}
		}
		return diagramList;
	}

	private static List<IFile> getDiagramFiles(IContainer folder) {
		final List<IFile> ret = new ArrayList<IFile>();
		try {
			final IResource[] members = folder.members();
			for (final IResource resource : members) {
				if (resource instanceof IContainer) {
					ret.addAll(getDiagramFiles((IContainer) resource));
				} else if (resource instanceof IFile) {
					final IFile file = (IFile) resource;
					if (file.getName().endsWith(".diagram")) {
						ret.add(file);
					}
				}
			}
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return ret;
	}

	private static Diagram getDiagramFromFile(IFile file, ResourceSet resourceSet) {
		// Get the URI of the model file.
		final URI resourceURI = getFileURI(file, resourceSet);
		// Demand load the resource for this file.
		Resource resource;
		try {
			resource = resourceSet.getResource(resourceURI, true);
			if (resource != null) {
				// does resource contain a diagram as root object?
				final EList<EObject> contents = resource.getContents();
				for (final EObject object : contents) {
					if (object instanceof Diagram) {
						return (Diagram) object;
					}
				}
			}
		} catch (final WrappedException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static URI getFileURI(IFile file, ResourceSet resourceSet) {
		final String pathName = file.getFullPath().toString();
		URI resourceURI = URI.createFileURI(pathName);
		resourceURI = resourceSet.getURIConverter().normalize(resourceURI);
		return resourceURI;
	}
	
	public static String getFilePath(Diagram diagram){
		//获得diagram的resource
		String uri = diagram.eResource().getURI().toString();
		//截取字符串，拼接成该图表文件所在路径
		String sub = uri.substring(19);
		String pathString = constant.path + sub;
//		System.out.println("字符串：" + sub);
//		System.out.println("文件路径：" + pathString);

		return pathString;
	}
		
	public static void openDiagramEditor(Diagram diagram) {
		// Found a diagram to open
		String diagramTypeProviderId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagram.getDiagramTypeId());
		GraphitiUiInternal.getWorkbenchService().openDiagramEditor(diagram, diagramTypeProviderId,
				getDiagramEditorId(diagram));
	}
	
	public static String getDiagramEditorId(Diagram diagram) {
		return DiagramEditor.DIAGRAM_EDITOR_ID;
	}
	
	
	public static IProject getCurrentProject(){    
        ISelectionService selectionService =     
            Workbench.getInstance().getActiveWorkbenchWindow().getSelectionService();    
    
        ISelection selection = selectionService.getSelection();    
    
        IProject project = null;    
        if(selection instanceof IStructuredSelection) {    
            Object element = ((IStructuredSelection)selection).getFirstElement();    
    
            if (element instanceof IResource) {    
                project= ((IResource)element).getProject();    
            }    
        }     
        return project;   // 获得当前文件所在的项目名 
    }  
	
		
	
	public static void changeText(ICustomContext context, PictogramElement element, Diagram diagram) {		
		Object obj = context.getInnerGraphicsAlgorithm();
		String oldText = "";
		TextImpl text = null;
		if (obj instanceof ImageImpl) {
			if (element instanceof ContainerShape) {
				ContainerShape cs = (ContainerShape) element;
				Shape shape = cs.getChildren().get(0);
				obj = shape.getGraphicsAlgorithm();
			}
		}
		if (obj instanceof TextImpl) {
			text = (TextImpl)obj;
			oldText = text.getValue();
//			text.setValue(newText);
		}
		String newText = JOptionPane.showInputDialog(null,"New text：\n",oldText);
		if (null == newText) {
			return;
		}
		text.setValue(newText);
		if(newText != oldText){
			NotifyChange.notifyChange(diagram);
			
		}
	}
	
}
