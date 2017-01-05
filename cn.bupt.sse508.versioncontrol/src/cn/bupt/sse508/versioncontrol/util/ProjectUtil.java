package cn.bupt.sse508.versioncontrol.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.internal.Workbench;

public class ProjectUtil {
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
        return project;    
    }    
}
