package graeditor.deployment.graphiti;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
import org.eclipse.graphiti.ui.platform.IImageProvider;

public class DeploymentImageProvider extends AbstractImageProvider implements IImageProvider{
	
	protected static final String PREFIX = "GraEditor.Deployment.";
	
	public static final String NODE  = PREFIX + "node";
	public static final String PROCESSORNODE  = PREFIX + "processorNode";

	@Override
	protected void addAvailableImages() {
		// TODO Auto-generated method stub
		addImageFilePath(NODE,"image/node.png");
		addImageFilePath(PROCESSORNODE,"image/processor_node.png");
	}

}
