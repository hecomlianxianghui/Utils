import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * 工具类
 * 
 * @author lianxianghui
 */
public class Utils {
	static String basePath = null;
	
	public static String getFileContent(String filePath) {
		return Utils.getFileContent(filePath, "UTF-8");
	}

	public static String getFileContent(String filePath, String encode) {
		try {
			BufferedReader bis = new BufferedReader(new InputStreamReader(
					new FileInputStream(new File(filePath)), encode));
			StringBuilder stringBuilder = new StringBuilder();
			String lineContent;

			while ((lineContent = bis.readLine()) != null) {
				stringBuilder.append(lineContent).append("\n");
			}
			bis.close();
			return stringBuilder.toString();
		} catch (Exception e) {
			return null;
		}
	}

	public static void writeFileContent(String filePath, String fileContent) {
		try {
			FileWriter fw = new FileWriter(filePath, false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(fileContent);
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String getBasePath() {
		if (basePath == null)
			basePath = Class.class.getClass().getResource("/").getPath();
		return basePath;
	}
}
