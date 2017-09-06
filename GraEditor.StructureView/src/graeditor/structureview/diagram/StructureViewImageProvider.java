package graeditor.structureview.diagram;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class StructureViewImageProvider extends AbstractImageProvider{
	protected static final String PREFIX = "img.graeditor.stuctureview.diagram.";
	
	public static final String FILE_REF = PREFIX + "file";
	public static final String FILEGROUP_REF = PREFIX + "filegroup";
	public static final String PAGE_REF = PREFIX + "page";
	public static final String PAGE_DELETE_RED_REF = PREFIX + "page-delte-red"; // 鍒犻櫎鐨勮櫄妗�
	public static final String PAGE_CONFICT_RED_REF = PREFIX + "page-conflict-red"; // 鍐茬獊鐨勫疄妗�
	public static final String PAGEGROUP_REF = PREFIX + "pagegroup";
	
	public static final String FILE_DELETE_RED_REF = PREFIX + "file-delte-red"; // 鍒犻櫎鐨勮櫄妗�
	public static final String FILE_CONFICT_RED_REF = PREFIX + "file-conflict-red"; // 鍐茬獊鐨勫疄妗�
	
	@Override
	protected void addAvailableImages() {
		addImageFilePath(FILE_REF, "image/file.png");
		addImageFilePath(FILEGROUP_REF, "image/filestack.png");
		addImageFilePath(PAGE_REF, "image/page.png");
		addImageFilePath(PAGE_DELETE_RED_REF, "image/page_conflict.png");
		addImageFilePath(PAGE_CONFICT_RED_REF, "image/page_conflict.png");
		addImageFilePath(PAGEGROUP_REF, "image/pagegroup.png");
		
		addImageFilePath(FILE_DELETE_RED_REF, "image/file_conflict.png");
		addImageFilePath(FILE_CONFICT_RED_REF, "image/file_conflict.png");
	}

}
