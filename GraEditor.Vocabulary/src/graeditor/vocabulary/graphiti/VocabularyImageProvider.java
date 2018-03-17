package graeditor.vocabulary.graphiti;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class VocabularyImageProvider extends AbstractImageProvider{
	
	protected static final String PREFIX = "GraEditor.Vocabulary.";
	
	public static final String AREA  = PREFIX + "area";
	public static final String FILE  = PREFIX + "file";
	public static final String PAGE  = PREFIX + "page";
	public static final String FILESTACK  = PREFIX + "filestack";
	public static final String PAGESTACK  = PREFIX + "pagestack";
	
	public static final String DECPOINT  = PREFIX + "decpoint";
	public static final String CONCURRENTSET  = PREFIX + "concurrentset";
	public static final String CONDBRANCH  = PREFIX + "condbranch";
	public static final String CLUSTER  = PREFIX + "cluster";
	public static final String CONDSELECT  = PREFIX + "condselect";
	
	public static final String CONTVERT  = PREFIX + "contvert";
	public static final String CONTHORZ  = PREFIX + "conthorz";
	
	@Override
	protected void addAvailableImages() {
		addImageFilePath(AREA,"image/area.png");
		addImageFilePath(FILE,"image/file.png");
		addImageFilePath(PAGE,"image/page.png");
		addImageFilePath(FILESTACK,"image/filestack.png");
		addImageFilePath(PAGESTACK,"image/pagestack.png");
		addImageFilePath(DECPOINT,"image/dec_point.png");
		addImageFilePath(CONCURRENTSET,"image/concurrent_set.png");
		
		addImageFilePath(CONDBRANCH,"image/cond_branch.png");
		addImageFilePath(CLUSTER,"image/cluster.png");
		addImageFilePath(CONDSELECT,"image/cond_select.png");
		addImageFilePath(CONTVERT,"image/cont_vert.png");
		addImageFilePath(CONTHORZ,"image/cont_horz.png");
		
	}

}
