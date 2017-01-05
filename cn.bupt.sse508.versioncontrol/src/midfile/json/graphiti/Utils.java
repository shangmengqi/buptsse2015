package midfile.json.graphiti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	

	/**
	 * 以行为单位读取文件，用于读面向行的格式化文件
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
