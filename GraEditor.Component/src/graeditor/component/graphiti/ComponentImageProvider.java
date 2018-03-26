package graeditor.component.graphiti;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;
import org.eclipse.graphiti.ui.platform.IImageProvider;

public class ComponentImageProvider extends AbstractImageProvider implements IImageProvider{
	
	protected static final String PREFIX = "GraEditor.Component.";
	
	public static final String COMPONENT  = PREFIX + "component";
	public static final String DATABASE  = PREFIX + "database";

	@Override
	protected void addAvailableImages() {
		addImageFilePath(COMPONENT,"image/component.png");
		addImageFilePath(DATABASE,"image/database.png");
	}

}
