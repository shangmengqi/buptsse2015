package graeditor.usecase.provider;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class UseCaseImageProvider  extends AbstractImageProvider{
	protected static final String PREFIX = "img.graeditor.usecase.diagram.";
	
	public static final String USER_REF = PREFIX + "user";
	public static final String USECASE_REF = PREFIX + "usecase";
	
	public static final String USECASE_DELETE_RED_REF = PREFIX + "usecase-delte-red"; // 鍒犻櫎鐨勮櫄妗�
	public static final String USECASE_CONFICT_RED_REF = PREFIX + "usecase-conflict-red"; // 鍐茬獊鐨勫疄妗�

	@Override
	protected void addAvailableImages() {
		addImageFilePath(USER_REF, "image/user.png");
		addImageFilePath(USECASE_REF, "image/usecase.png");
		
		addImageFilePath(USECASE_DELETE_RED_REF, "image/usecase_conflict.png");
		addImageFilePath(USECASE_CONFICT_RED_REF, "image/usecase_conflict.png");
	}

}
