package graeditor.usecase.features;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import graeditor.utils.DiagramUtil;
import graeditor.utils.MyDrillDownFeature;

public class DrillDownFeature extends MyDrillDownFeature{

	public DrillDownFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
    public String getName() {
        return "Open associated diagram";
    }
 
    @Override
    public String getDescription() {
        return "Open the diagram associated with this EClass";
    }
    
    @Override
    public boolean canExecute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();//��ȡ��ǰ����������ͼ��Ԫ��
        // first check, if one EClass is selected
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);            
            return true;
        }
        return false;
    }
    
    /**
     * ��ȡͬһ����Ŀ�µ�����ͼ��
     */
	@Override
	public Collection<Diagram> getDiagrams() {
		Collection<Diagram> result = Collections.emptyList();
		Resource resource = getDiagram().eResource();
		URI uri = resource.getURI();
		URI uriTrimmed = uri.trimFragment();
		if (uriTrimmed.isPlatformResource()) {
			String platformString = uriTrimmed.toPlatformString(true);
			IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (fileResource != null) {
				IProject project = fileResource.getProject();
				result = DiagramUtil.getDiagrams(project);
			}
		}
		return result;//result���ر༭����ͬһ����Ŀ�����е�diagramͼ����Ϣ������ͼ�����ƣ�������Щdiagram����һ��������
	}

}
