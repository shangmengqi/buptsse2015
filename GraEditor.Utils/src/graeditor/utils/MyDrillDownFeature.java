package graeditor.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractDrillDownFeature;

public class MyDrillDownFeature extends AbstractDrillDownFeature{

	public MyDrillDownFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	protected Collection<Diagram> getDiagrams() {
		Collection<Diagram> result = Collections.emptyList();
		Resource resource = getDiagram().eResource();
		URI uri = resource.getURI();
		URI uriTrimmed = uri.trimFragment();
		if (uriTrimmed.isPlatformResource()) {
			String platformString = uriTrimmed.toPlatformString(true);
			IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (fileResource != null) {
				IProject project = fileResource.getProject();
				result = DiagramUtil.getDiagrams(project);
			}
		}
		return result;//result返回编辑器上同一个项目下所有的diagram图表信息，包括图表名称，并将这些diagram存在一个数组里
	}
	
	/**
	 * A list of all diagrams, which are connected to the given
	 *         pictogram element.
	 */
	@Override
	protected Collection<Diagram> getLinkedDiagrams(PictogramElement pe) {

		final Collection<Diagram> ret = new HashSet<Diagram>();

		final Object[] businessObjectsForPictogramElement = getAllBusinessObjectsForPictogramElement(pe);

		final Collection<Diagram> allDiagrams = getDiagrams();
		for (final Diagram d : allDiagrams) {
			final Diagram currentDiagram = getDiagram();//currentDiagram为当前要进行跳转的图表
			if (!EcoreUtil.equals(currentDiagram, d)) { // always filter out the
														// current
				
				d.getName();
				
				if (d.getLink() != null) {
					System.out.println("getLink: " + d.getLink());
					EList<EObject> eList = d.getLink().getBusinessObjects();
					System.out.println("eList : " + eList);
					for (int i = 0; i < eList.size(); i++) {
						System.out.println("eListResource: " + eList.get(i));
						
						//字符串的拆分
						String string = eList.get(i).toString();
						String[] array = new String[20];
						array = string.split("/");
						if (array.length > 2) {
							String s1 = array[array.length-1];
							String s2 = array[array.length-2];
							System.out.println(s1);
							System.out.println(s2);
							
							int diagramObj = Integer.parseInt(s1.substring(0, s1.length()-1)) ;
							String diagramString = s2.substring(0, s2.length()-9);
							System.out.println("diagramObj : " + diagramObj);
							System.out.println("diagramString : " + diagramString);
							
							
							//DrillDown的逻辑实现，将含有跟当前图表和元素相等的图表添加到数组中
							if (currentDiagram.getName().equals(diagramString)) {
								
//								System.out.println("peGetLink : " + pe.getLink().getBusinessObjects());
//								System.out.println("currentDiagramChildrenNumber : " + currentDiagram.getChildren().size());
								for (int j = 0; j < currentDiagram.getChildren().size(); j++) {
									if (currentDiagram.getChildren().get(j).equals(pe)) {
										int currentObj = j + 1;
//										System.out.println("currentBObject : " + currentObj);
										if (diagramObj == currentObj) {
											ret.add(d);
										}
									}
								}
							}
						
						}
					}
					
				}						
			}
		}
		return ret;
	}

}
