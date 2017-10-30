package graeditor.flow.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

public class CustomShowMergeDiagram extends AbstractCustomFeature{
	
	private static boolean canDelete = true;

	public CustomShowMergeDiagram(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void execute(ICustomContext context) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean isCanDelete(){
		return canDelete;
	}
	
	public static void setCanDelete(boolean flag) {
		canDelete = flag;
	}

}
