package graeditor.utils;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

public class GraPropertyUtil {
 
    /**
     * 设置PictogramElement的Property
     * @param pe 图形元素
     * @param key 设定的键
     * @param value 设定的值
     */
    public static final void setValue(PictogramElement pe, String key, String value) {
        Graphiti.getPeService().setPropertyValue(pe, key,
            value);
    }
    
    /**
     * 返回特定元素的值
     * @param pe 图形元素
     * @param key 键
     * @return
     */
    public static String getValue(PictogramElement pe, String key) {
    	return Graphiti.getPeService().getPropertyValue(pe, key);
    }
    
}