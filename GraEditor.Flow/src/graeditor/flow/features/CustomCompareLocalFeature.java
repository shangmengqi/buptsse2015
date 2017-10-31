package graeditor.flow.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import cn.bupt.sse508.versioncontrol.util.CompareLocal;

public class CustomCompareLocalFeature extends AbstractCustomFeature{

	public CustomCompareLocalFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	public String getName() {
		return "Local Compare";
	}
	
	@Override
	public String getDescription() {
		return "比较用户当前正在编辑的图表文件和服务器端已存在的图表文件的不同";
	}
	
	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		Diagram currentDiagram = getDiagram();
		String currentDiagramName = currentDiagram.getName();
		
		String uriString = currentDiagram.eResource().getURI().toString().substring(18);
		String currentDiagramPath = "E:/Git/buptsse2015/runtime-EclipseApplication" + uriString;
		
		System.out.println(currentDiagramPath);
		
//		ToMidFile.toMidFile(currentDiagramPath);
		CompareLocal.compareLocal(currentDiagramPath, currentDiagramName);
	}

}
