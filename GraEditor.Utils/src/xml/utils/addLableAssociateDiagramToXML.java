package xml.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 未使用
 * @author dell
 *
 */
public class addLableAssociateDiagramToXML {
	
	public static void addLink(String filePath, String diagramName, int objectNum){
		String num = String.valueOf(objectNum);
		File file = new File(filePath);				
		SAXReader reader = new SAXReader();
		Document document;
		
		try {
			document = reader.read(file);
			Element rooElement = document.getRootElement();
			System.out.println("root :" + rooElement);			
//				outputLocationAttributes(rooElement);			
			Element diagram = rooElement.element("Diagram");
						
			getChildrenPropert(diagram);
						
			FileWriter writer = new FileWriter(file);
			OutputFormat format = OutputFormat.createPrettyPrint();  
	        format.setEncoding("ASCII");  
	        XMLWriter writer1 = new XMLWriter(writer,format); 
	        writer1.write(document);  
	        writer1.flush();
	        writer1.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
	}
	
	public static void  getChildrenPropert(Element element) {
		for (int i = 0; i < element.nodeCount(); i++) {
			Node node = element.node(i);
			if (node instanceof Element) {
				Element child1 = (Element) node ;
				if(child1.getName().equals("children")){
					System.out.println("child1 :" + child1.getName());
					for (int j = 0; j < child1.nodeCount(); j++) {
						Node node2 = child1.node(j);
						if (node2 instanceof Element) {
							Element child2 = (Element) node2 ;
							if (child2.getName().equals("link")) {
								if (child2.attributeValue("businessObjects").contains("9")) {
									System.out.println("child2.attributeValue :" + child2.attributeValue("businessObjects"));
									
									Element properties = child1.addElement("properties");
									properties.addAttribute("key", "associate_diagram");
									properties.addAttribute("value", "struct.diagram");
								}
							}										
						}
					}
				}
			}						
		}
	}

}
