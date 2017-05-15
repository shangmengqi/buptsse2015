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
		
		//����Ҫ���������ļ������link��ǩ
		File file = new File(filePath);				
		SAXReader reader = new SAXReader();
		Document document;
		try {
			document = reader.read(file);
			Element rooElement = document.getRootElement();
			System.out.println("root :" + rooElement);			
//			outputLocationAttributes(rooElement);			
			Element diagram = rooElement.element("Diagram");
			
			//����diagram�ڵ��µ������ӽڵ�,�鿴�Ƿ���link��ǩ
			for (int i = 0; i < diagram.nodeCount(); i++) {
				Node node = diagram.node(i);				
				if (node instanceof Element) {
//					System.out.println("nodeName: " + node.getName());					
					if (node.getName().equals("link")) {
						System.out.println("link��ǩ���ڣ�ִ���滻����");
//						Element childElement = (Element) node;
						diagram.remove(node);
					}
				}
			}			
			
			//��ָ��λ�����link��ǩ
			List list = diagram.elements();			
			Element link = DocumentHelper.createElement("link");
			Element bussinessObjectElement = link.addElement("businessObjects");
			bussinessObjectElement.setAttributeValue("href", diagramName + ".diagram#/" + objectNum);
			list.add(1, link);
			
			//����ӵ�����д���ļ���
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
	 * xml�ļ��ı���
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
//							System.out.println("���� �� " + j);							
//						}
//						if (child2.getName().equals("children")) {
//							System.out.println("���� �� " + j);													
//						}
//					}
//				}				
//			}
//		}
//	}
	
//	public static boolean deleteFile(String fileName) {
//        File file = new File(fileName);
//        // ����ļ�·������Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ��
//        if (file.exists() && file.isFile()) {
//            if (file.delete()) {
//                System.out.println("ɾ�������ļ�" + fileName + "�ɹ���");
//                return true;
//            } else {
//                System.out.println("ɾ�������ļ�" + fileName + "ʧ�ܣ�");
//                return false;
//            }
//        } else {
//            System.out.println("ɾ�������ļ�ʧ�ܣ�" + fileName + "�����ڣ�");
//            return false;
//        }
//    }
	  
}
