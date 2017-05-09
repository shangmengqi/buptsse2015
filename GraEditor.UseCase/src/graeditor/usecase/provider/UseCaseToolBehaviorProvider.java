package graeditor.usecase.provider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextMenuEntry;

import graeditor.usecase.features.SolveConflictFeature;

public class UseCaseToolBehaviorProvider extends DefaultToolBehaviorProvider {
	private ContextMenuEntry subMenu;
	
	public UseCaseToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
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

	/*
	 * 在这里判断所选择的元素是否为冲突元素
	 */
	@Override
	public PictogramElement getSelection(PictogramElement originalPe, PictogramElement[] oldSelection) {
		int numOfSelection = oldSelection.length + 1;
		boolean flag = true;
		boolean[] isElementsConflict = new boolean[numOfSelection];
		
		{
			EList<Property> pList = originalPe.getProperties();
			for (int j = 0; j < pList.size(); j++) {
				if (pList.get(j).getValue().equals("conflict")) { // 判断是否有冲突
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
					if (pList.get(j).getValue().equals("conflict")) { // 判断是否有冲突
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
			SolveConflictFeature.setCanExecute(true);
		} else { // 至少有一个被选择的元素是不在冲突列表中的
			SolveConflictFeature.setCanExecute(false);
		}

		return super.getSelection(originalPe, oldSelection);
	}

}
