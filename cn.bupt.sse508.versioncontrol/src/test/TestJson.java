package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.XML;

import midfile.json.graphiti.FromMidFile;
import midfile.json.graphiti.ToMidFile;
import midfile.json.graphiti.Utils;

public class TestJson {

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;

	public static void main(String[] args) {
			
		// xml转中间文件
		String midfilecontent = ToMidFile
				.toMidFile("D:/git/runtime-Graphiti/Graph/src/newDiagram.diagram"); // StructureView
		System.out.println(midfilecontent);
		
		// 中间文件转xml
//		String midfilecontent = Utils.readFileByLines("D:/midfile.txt");
//		String xml = FromMidFile.fromMidFile(midfilecontent);
//		System.out.println(xml);
			
			// 通用json转xml
//			System.out.println("============================================");
//			String xml = XML.toString(new JSONObject(readFileByLines("D:/test_json.txt")));
//			System.out.println(xml);

	}
	
    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String temp = "";
            // 一次读入一行，直到读入null为文件结束
            while ((temp = reader.readLine()) != null) {
                sb.append(temp);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return sb.toString();
    }
}
