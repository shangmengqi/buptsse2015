package graeditor.usecase.provider;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class UseCaseImageProvider  extends AbstractImageProvider{
	protected static final String PREFIX = "img.graeditor.usecase.diagram.";
	
	public static final String USER_REF = PREFIX + "user";
	public static final String USECASE_REF = PREFIX + "usecase";

	@Override
	protected void addAvailableImages() {
		addImageFilePath(USER_REF, "image/user.png");
		addImageFilePath(USECASE_REF, "image/usecase.png");
	}

}
