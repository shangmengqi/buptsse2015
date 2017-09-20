package graeditor.flow.graphiti;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextMenuEntry;

import graeditor.flow.features.CustomDeleteFeature;


public class FlowViewToolBehaviorProvider extends DefaultToolBehaviorProvider{

	private ContextMenuEntry subMenu;

	
	public FlowViewToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
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
	
	@Override
	public PictogramElement getSelection(PictogramElement originalPe, PictogramElement[] oldSelection) {
		System.out.println("start getSelection function 111111111111111111111111");
		int numOfSelection = oldSelection.length + 1;
		boolean flag = true;
		boolean[] isElementsConflict = new boolean[numOfSelection];
		
		// 新加入selection的元素和原本selection中的元素都冲突时才能使这个邮件菜单valid
		{
			EList<Property> pList = originalPe.getProperties();
			for (int j = 0; j < pList.size(); j++) {
				if (pList.get(j).getValue().contains("conflict")) { // 判断是否有冲突
					isElementsConflict[0] = true;
					break;
				} else { // 只要
					continue;
				}
			}
		}

		if (isElementsConflict[0] == true) {
			for (int i = 0; i < oldSelection.length; i++) {
				EList<Property> pList = oldSelection[i].getProperties();
				for (int j = 0; j < pList.size(); j++) {
					if (pList.get(j).getValue().contains("conflict")) { // 判断是否有冲突
						isElementsConflict[i+1] = true;
						break;
					} else { 
						continue;
					}
				}

				if (isElementsConflict[i+1] == false) {
					flag = false;
					break;
				}
			} 
		} else {
			flag = false;
		}
		
		if (flag == true) { // 可以进行冲突处理
			CustomDeleteFeature.setCanDelete(true);
		} else { // 至少有一个被选择的元素是不在冲突列表中的
			CustomDeleteFeature.setCanDelete(false);
		}

		return super.getSelection(originalPe, oldSelection);
	}

}
