package graeditor.relation.graphiti;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextMenuEntry;


public class RelationViewToolBehaviorProvider extends DefaultToolBehaviorProvider{
	
	private ContextMenuEntry subMenu;

	public RelationViewToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
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

		// ��˳���Ӧ��custom feature�б���feature Provider��ע��
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
		int numOfSelection = oldSelection.length + 1;
		boolean flag = true;
		boolean[] isElementsConflict = new boolean[numOfSelection];
		
		// �¼���selection��Ԫ�غ�ԭ��selection�е�Ԫ�ض���ͻʱ����ʹ����ʼ��˵�valid
		{
			EList<Property> pList = originalPe.getProperties();
			for (int j = 0; j < pList.size(); j++) {
				if (pList.get(j).getValue().contains("conflict")) { // �ж��Ƿ��г�ͻ
					isElementsConflict[0] = true;
					break;
				} else { // ֻҪ
					continue;
				}
			}
		}

		if (isElementsConflict[0] == true) {
			for (int i = 0; i < oldSelection.length; i++) {
				EList<Property> pList = oldSelection[i].getProperties();
				for (int j = 0; j < pList.size(); j++) {
					if (pList.get(j).getValue().contains("conflict")) { // �ж��Ƿ��г�ͻ
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
		
		if (flag == true) { // ���Խ��г�ͻ����
//			CustomDeleteFeature.setCanDelete(true);
		} else { // ������һ����ѡ���Ԫ���ǲ��ڳ�ͻ�б��е�
//			CustomDeleteFeature.setCanDelete(false);
		}

		return super.getSelection(originalPe, oldSelection);
	}

}
