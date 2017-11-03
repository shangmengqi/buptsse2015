package graeditor.flow.graphiti;

import java.util.Collection;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;

import com.graeditor.flow_model.Flow;
import com.graeditor.flow_model.FlowModule;
import com.graeditor.flow_model.StartTagModule;

import graeditor.flow.features.CustomDeleteFeature;
import graeditor.flow.features.FlowDrillDownFeature;
import graeditor.utils.MyDrillDownFeature;



public class FlowViewToolBehaviorProvider extends DefaultToolBehaviorProvider{

	private ContextMenuEntry subMenu;

	
	public FlowViewToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}
	
	@Override
	public Object getToolTip(GraphicsAlgorithm ga) {
		PictogramElement pe = ga.getPictogramElement();
	    Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(pe);
	    
	 // 拿出该节点中所有的properties,并判断该节点是新添加的节点还是用户删除的节点
	    EList<Property> propertiesList = pe.getProperties(); 
	    for (int i = 0; i < propertiesList.size(); i++) {
			String valueString = propertiesList.get(i).getValue();
			String keyString = propertiesList.get(i).getKey();
			if (valueString.contains("delete")) {
				return "this is a delete node";
			}else if (valueString.contains("add")) {
				return "this is a add node";
			}
			
			if (keyString.contains("alternative_text")) {				
				return "this node has original value is " + valueString;
			}

		}
        return null;         
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
	
	// 上下文按钮功能
//	@Override
//	public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {
//		IContextButtonPadData data = super.getContextButtonPad(context);
//		PictogramElement pe = context.getPictogramElement();
//		
//		 setGenericContextButtons(data, pe, CONTEXT_BUTTON_DELETE | CONTEXT_BUTTON_UPDATE);
//		 
//		CustomContext cc = new CustomContext();
//		cc.setPictogramElements(new PictogramElement[]{pe});
//		
//	    CreateConnectionContext ccc = new CreateConnectionContext();		    
//	    ccc.setSourcePictogramElement(pe);
//
//		        
//	    ContextButtonEntry button = new ContextButtonEntry(null, cc);
//	    button.setText("Associate diagram");
//	    button.setIconId(FlowImageProvider.TEXT);
//		    
//		    for (ICustomFeature feature : getFeatureProvider().getCustomFeatures(cc)) {
//		    	if (feature.getName().contains("Back associate diagram")) {
//		    		button.addDragAndDropFeature(feature);
//				}
//		       
//		    }
//		 
//		    // 3.c. add context button, if it contains at least one feature
//		    if (button.getDragAndDropFeatures().size() > 0) {
//		       data.getDomainSpecificContextButtons().add(button);
//		    }
//		    
//		    return data;
//	}
	
	
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
		
		IFeatureProvider featureProvider = getFeatureProvider();
		Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);
		
		if (bo instanceof StartTagModule) {
			FlowModule eClass = (FlowModule) bo;	        
            IDecorator imageRenderingDecorator = new ImageDecorator( IPlatformImageConstants.IMG_ECLIPSE_QUICKASSIST);
            imageRenderingDecorator.setMessage("Name should start with upper case letter");
            return new IDecorator[] { imageRenderingDecorator };
	        }
		return super.getDecorators(pe);
	}

}
