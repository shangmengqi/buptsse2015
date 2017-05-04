package xml.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.internal.Workbench;

public class addLinkToXML {


	public static void addLink(String filePath, String diagramName, int objectNum){
		
		//读入要被关联的文件并添加link标签
		File file = new File(filePath);				
		SAXReader reader = new SAXReader();
		Document document;
		try {
			document = reader.read(file);
			Element rooElement = document.getRootElement();
			System.out.println("root :" + rooElement);			
//			outputLocationAttributes(rooElement);			
			Element diagram = rooElement.element("Diagram");
			List list = diagram.elements();
			
			Element link = DocumentHelper.createElement("link");
			Element bussinessObjectElement = link.addElement("businessObjects");
			bussinessObjectElement.setAttributeValue("href", diagramName + ".diagram#/" + objectNum);
			list.add(1, link);
			
			System.out.println("FilePath:");
			
			//将添加的数据写入文件中
			FileWriter writer = new FileWriter(file);
			OutputFormat format = OutputFormat.createPrettyPrint();  
	        format.setEncoding("ASCII");  
	        XMLWriter writer1 = new XMLWriter(writer,format); 
	        writer1.write(document);  
	        writer1.flush();
	        writer1.close();	
//	        outputLocationAttributes(rooElement);			
				        			
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
	
	/*
	 * xml文件的遍历
	 */
//	public static void outputLocationAttributes(Element parent){
//		for (int i = 0; i < parent.nodeCount(); i++) {
//			Node node = parent.node(i);
//			if (node instanceof Element) {
//				Element child1 = (Element) node;
//				System.out.println("rootChild1 :" + child1.getName());
//										
//				for (int j = 0; j < child1.nodeCount(); j++) {
//					Node node2 = child1.node(j);
//					
//					if (node2 instanceof Element) {
//						Element child2 = (Element)node2;
//						System.out.println("rootChild2 :" + child2.getName());
//						
//						if (child2.getName().equals("graphicsAlgorithm")) {
//							System.out.println("索引 ： " + j);							
//						}
//						if (child2.getName().equals("children")) {
//							System.out.println("索引 ： " + j);													
//						}
//					}
//				}				
//			}
//		}
//	}
	
//	public static boolean deleteFile(String fileName) {
//        File file = new File(fileName);
//        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
//        if (file.exists() && file.isFile()) {
//            if (file.delete()) {
//                System.out.println("删除单个文件" + fileName + "成功！");
//                return true;
//            } else {
//                System.out.println("删除单个文件" + fileName + "失败！");
//                return false;
//            }
//        } else {
//            System.out.println("删除单个文件失败：" + fileName + "不存在！");
//            return false;
//        }
//    }
	  
}
