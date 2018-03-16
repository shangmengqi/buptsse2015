package graeditor.flow.graphiti;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class FlowImageProvider extends AbstractImageProvider{
	
	protected static final String PREFIX = "GraEditor.Flow.";
	
	public static final String CONTROL  = PREFIX + "control";
	public static final String HEBING  = PREFIX + "control";
	
	public static final String TEXT  = PREFIX + "text";
	
	public static final String FENCHA  = PREFIX + "fencha";
	public static final String HUIHE  = PREFIX + "huihe";

	@Override
	protected void addAvailableImages() {
		addImageFilePath(CONTROL,"image/control1.png");
		addImageFilePath(HEBING,"image/control1.png");
		addImageFilePath(TEXT,"image/text.png");
		addImageFilePath(FENCHA,"image/huihe.png");
		addImageFilePath(HUIHE,"image/huihe.png");
	}

}
