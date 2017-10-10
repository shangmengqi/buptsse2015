package graeditor.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class NotifyChange{
	
	public static void notifyChange(Diagram diagram){
		System.out.println("该节点发生修改");
		
		
		/*
		 * 遍历该节点所在项目下所有图表文件,返回图表文件列表
		 */
		final Collection<Diagram> ret = new HashSet<Diagram>();
		Collection<Diagram> result = Collections.emptyList();
		Resource resource = diagram.eResource();
		URI uri = resource.getURI();
		URI uriTrimmed = uri.trimFragment();
		if (uriTrimmed.isPlatformResource()) {
			String platformString = uriTrimmed.toPlatformString(true);
			IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (fileResource != null) {
				IProject project = fileResource.getProject();
				System.out.println("project: " + project);
				result = DiagramUtil.getDiagrams(project);
				System.out.println("result: " + result);
			}
		}
		final Collection<Diagram> allDiagrams = result;
		
		for (final Diagram d : allDiagrams) {
			String diagramName = diagram.getName();
			if (!EcoreUtil.equals(diagram, d)) { // always filter out the														// current
				System.out.println("d: " + d.getName());
				
				ret.add(d);																							
			}			
		}
		System.out.println("ret: " + ret.size());
		
		/*
		 * 找出包含link的图表文件,返回到列表
		 */
		
		
		
		/*
		 * 找出link标签关联了当前节点的图表文件的图表,
		 * 弹出提示框，询问该节点关联了这个图表文件，是否继续当前操作
		 * 是：打开关联的图表文件
		 * 否：不进行任何操作
		 */
		
		
		
	}
	
	

}
