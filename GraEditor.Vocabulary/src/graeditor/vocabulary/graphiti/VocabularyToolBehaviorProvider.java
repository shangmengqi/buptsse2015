package graeditor.vocabulary.graphiti;

import java.util.Collection;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;



import graeditor.utils.MyDrillDownFeature;

public class VocabularyToolBehaviorProvider extends DefaultToolBehaviorProvider{
	
	private ContextMenuEntry subMenu;

	public VocabularyToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}
	
	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext context) {
		// create a sub-menu for all custom features
		subMenu = new ContextMenuEntry(null, context);
		subMenu.setText("Custom");
		subMenu.setDescription("Custom Features");
		// display sub-menu hierarchical or flat
		subMenu.setSubmenu(true);

		// 按顺序对应于custom feature列表，在feature Provider中注册
		// create a menu-entry in the sub-menu for each custom feature
		ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
		for (int i = 0; i < customFeatures.length; i++) {
			ICustomFeature customFeature = customFeatures[i];
			if (customFeature.isAvailable(context)) {
				ContextMenuEntry menuEntry = new ContextMenuEntry(customFeature, context);
				menuEntry.setText(customFeature.getName());
				subMenu.add(menuEntry);
			}
		}

		IContextMenuEntry ret[] = new IContextMenuEntry[] { subMenu };
		return ret;
	}
	
	/**
	 *  在包含跳转的图形元素上添加某些小图标进行标注，告诉用户该节点关联了哪个图表，以及引导用户打开关联的图表进行查看
	 *  为某些图形元素添加标注信息
	 */
	@Override
	public IDecorator[] getDecorators(PictogramElement pe) {
		CustomContext cc = new CustomContext();
		cc.setPictogramElements(new PictogramElement[]{pe});
		for (ICustomFeature feature : getFeatureProvider().getCustomFeatures(cc)) {
	    	if (feature.getName().contains("Open associated diagram")) {
	    		Collection<Diagram> result = ((MyDrillDownFeature) feature).getLinkedDiagrams(pe);
	    		if (result != null) {
	    			Diagram diagram = null;
	    			final Diagram[] possibleDiagrams = result.toArray(new Diagram[0]);
	    			for (int i = 0; i < possibleDiagrams.length; i++) {
						System.out.println("hahahahaha: " + possibleDiagrams[i].getName());
						IDecorator imageRenderingDecorator = new ImageDecorator( IPlatformImageConstants.IMG_DIAGRAM);
			            imageRenderingDecorator.setMessage("这个图形元素关联了'" + possibleDiagrams[i].getName() + ".diagram'图表,你可以通过选中该元素，右击鼠标，选择Custom-->Open associated diagram,查看关联的图表。");
			            return new IDecorator[] { imageRenderingDecorator };
					}
				}
			}
	       
	    }
		
		
		return super.getDecorators(pe);
	}

}


