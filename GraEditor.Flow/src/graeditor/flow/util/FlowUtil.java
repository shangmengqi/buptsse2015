//package graeditor.flow.util;
//
//import org.eclipse.graphiti.features.IFeatureProvider;
//import org.eclipse.graphiti.mm.pictograms.ContainerShape;
//import org.eclipse.graphiti.mm.pictograms.PictogramElement;
//import org.eclipse.graphiti.mm.pictograms.Shape;
//
//import com.graeditor.flow_model.FlowModule;
//
//public class FlowUtil {
//	
//	/**
//	 * 通过内部的shape访问绑定在外部的FlowModule
//	 */
//	public static FlowModule getModuleByInnerPictogramElement
//	(IFeatureProvider fp, PictogramElement innerShape){
//		Shape shape = (Shape) innerShape;
//		ContainerShape outer = shape.getContainer();
//		return (FlowModule) fp.getBusinessObjectForPictogramElement(outer);		
//	}
//
//}
