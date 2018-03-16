package graeditor.vocabulary.graphiti;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class VocabularyImageProvider extends AbstractImageProvider{
	
	protected static final String PREFIX = "GraEditor.Vocabulary.";
	
	public static final String AREA  = PREFIX + "area";
	public static final String FILE  = PREFIX + "file";
	public static final String PAGE  = PREFIX + "page";
	public static final String FILESTACK  = PREFIX + "filestack";
	public static final String PAGESTACK  = PREFIX + "pagestack";

	@Override
	protected void addAvailableImages() {
		addImageFilePath(AREA,"image/area.png");
		addImageFilePath(FILE,"image/file.png");
		addImageFilePath(PAGE,"image/page.png");
		addImageFilePath(FILESTACK,"image/filestack.png");
		addImageFilePath(PAGESTACK,"image/pagestack.png");
	}

}
