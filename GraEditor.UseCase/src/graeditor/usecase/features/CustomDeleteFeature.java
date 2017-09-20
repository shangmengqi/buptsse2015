package graeditor.usecase.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.impl.ImageImpl;
import org.eclipse.graphiti.mm.algorithms.impl.TextImpl;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

import graeditor.utils.ValueUtil;

public class CustomDeleteFeature extends AbstractCustomFeature{
	private static boolean canDelete = false;

	public CustomDeleteFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public boolean canExecute(ICustomContext context) {
		return canDelete;
	}

	@Override
	public String getName() {
		return "Solve Conflict";
	}
	
	@Override
    public String getDescription() {
        return "Solve the Conflict of the selected Element";
    }

	@Override
	public void execute(ICustomContext context) {
		// TODO Auto-generated method stub
		// 获取这个元素的property，判断是text冲突还是删除冲突
				// 在这里只处理第一个选中的元素
				PictogramElement element = context.getPictogramElements()[0];
				EList<Property> pList = element.getProperties();
				for (int i = 0; i < pList.size(); i++) {
					if (pList.get(i).getKey().equals("info")) {
						if (pList.get(i).getValue().equals(ValueUtil.CONFLICT_DELETE)) { // 删除冲突
							// 构造弹出提示的对话框，提示用户选择删除这个节点或者是保留当前状态
							MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
									ValueUtil.TITLE_NODE_WITH_CONFLICT, null, "My message", MessageDialog.ERROR, 
									new String[] { "delete", "keep" }, 0);
							int result = dialog.open();
							if (result == 0) { // 删除操作
								// 构造一个deleteContext，交由featureprovider来进行删除提交
								DeleteContext dc = new DeleteContext(element);
								getFeatureProvider().getDeleteFeature(dc).delete(dc);
								
							} else { // 保留操作
								
							}
							
							// TODO 删除冲突描述文件中的对应节点
						} else { // 替换文字冲突
							
							// 获取这个节点的文字信息
							TextImpl text = null;
							String oldText = "";
							String newText = "";
							Object obj = context.getInnerGraphicsAlgorithm();
							if (obj instanceof ImageImpl) {
								if (element instanceof ContainerShape) {
									ContainerShape cs = (ContainerShape) element;
									Shape shape = cs.getChildren().get(0);
									obj = shape.getGraphicsAlgorithm();
								}
							}
							if (obj instanceof TextImpl) {
								text = (TextImpl)obj;
								oldText = text.getValue();
							}
							
							// 获取版本B的文字信息
							{
								for (int j = 0; j < pList.size(); j++) {
									if (pList.get(j).getKey().equals(ValueUtil.ALTERNATIVE_TEXT)) {
										newText = pList.get(j).getValue();
										break;
									}
								}
							}
							
							// 构造弹出提示的对话框，提示用户选择删除这个节点或者是保留当前状态
							String messageA = "Version A has Text \"" + oldText +"\"\n";
							String messageB = "Version B has Text \"" + newText +"\"\n";
							String messageC = "Which to keep?";
							MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
									ValueUtil.TITLE_NODE_WITH_CONFLICT, null, messageA+messageB+messageC, MessageDialog.ERROR, 
									new String[] { "keep A", "keep B" }, 0);
							int result = dialog.open();
							
							if (result == 0) { // 替换文字
								text.setValue(oldText);
							} else if (result == 1){
								text.setValue(newText);
							}
							
							// 去掉红色框框
							ImageImpl image = null;
							if (element instanceof ContainerShape) {
								image = (ImageImpl) element.getGraphicsAlgorithm();
								String id = image.getId();
								id = id.substring(0, id.indexOf("-"));
								image.setId(id);
							}
							
							// 删除描述文件中对应的节点
							{
								for (int j = 0; j < pList.size(); j++) {
									if (pList.get(j).getKey().equals(ValueUtil.ALTERNATIVE_TEXT)) {
										pList.remove(j);
										break;
									}
								}
								
								for (int j = 0; j < pList.size(); j++) {
									if (pList.get(j).getValue().equals(ValueUtil.CONFLICT_TEXT)) {
										pList.remove(j);
										break;
									}
								}
							}
							break;
						}
						break;
					}
				}
	}
	
	public static boolean isCanDelete() {
		return canDelete;
	}

	public static void setCanDelete(boolean flag) {
		canDelete = flag;
	}

}
