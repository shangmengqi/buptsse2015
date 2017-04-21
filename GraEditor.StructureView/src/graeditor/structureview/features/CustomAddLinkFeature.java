//package graeditor.structureview.features;
//
//import java.io.IOException;
//
//import org.dom4j.DocumentException;
//import org.eclipse.graphiti.features.IFeatureProvider;
//import org.eclipse.graphiti.features.context.ICustomContext;
//import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
//
//import xml.utils.addLinkToXML;
//
//public class CustomAddLinkFeature extends AbstractCustomFeature{
//
//	public CustomAddLinkFeature(IFeatureProvider fp) {
//		super(fp);
//	}
//
//	@Override
//	public void execute(ICustomContext context) {
//		try {
//			addLinkToXML.addLink(getDiagram().getName());
//		} catch (DocumentException | IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
