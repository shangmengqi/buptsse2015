package graeditor.flow.graphiti;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class FlowImageProvider extends AbstractImageProvider{
	
	protected static final String PREFIX = "GraEditor.Flow.";
	
	public static final String CONTROL  = PREFIX + "control";

	@Override
	protected void addAvailableImages() {
		addImageFilePath(CONTROL,"image/control.png");
	}

}
