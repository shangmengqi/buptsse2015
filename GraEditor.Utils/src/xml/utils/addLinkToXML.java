package xml.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class addLinkToXML {


	public static void addLink(String diagramName){
		SAXReader reader = new SAXReader();
		Document document;
		try {
			document = reader.read(new File("E:/Git/buptsse2015/runtime-EclipseApplication/test/src/relation/" + diagramName + ".diagram"));
			Element rooElement = document.getRootElement();
			System.out.println("root :" + rooElement);
			
			Element diagram = rooElement.element("Diagram");
			List list = diagram.elements();
			
			Element link = DocumentHelper.createElement("link");
			Element bussinessObjectElement = link.addElement("bussinessObject");
			bussinessObjectElement.setAttributeValue("href", "struct.diagram#/1");
			list.add(1, link);
			
			OutputFormat format = OutputFormat.createPrettyPrint();  
	        format.setEncoding("ASCII");  
	        XMLWriter writer = new XMLWriter(  
	                format);  
	        writer.write(document);  
	        writer.close();	
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}
}
