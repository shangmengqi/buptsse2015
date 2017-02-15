package graeditor.flow.graphiti;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class FlowImageProvider extends AbstractImageProvider{
	
	//protected static final String PREFIX = "img.graeditor.flow.graphiti.";
	
	public static final String VERTICAL_LINE  = "line";

	@Override
	protected void addAvailableImages() {
		addImageFilePath(VERTICAL_LINE,"image/line.png");
	}

}
