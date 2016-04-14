import java.util.List;


/**
 * 
 * @author lianxianghui
 */
public class FieldsToProperties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i = i + 2) {
			if (i + 1 >= args.length) {// 必须是成对的
				System.out.println("输入参数有误");
				return;
			}
			String argType = args[i];
			String filePath = null;
			if (argType.equals("-f")) {
				filePath = args[i + 1];
				boolean isRelativePath = (filePath.charAt(0) != '/');
				if (isRelativePath)
					filePath = Utils.getBasePath() + filePath;
			}
			String fileContent = Utils.getFileContent(filePath);
			String[] lines = fileContent.split("\n");
			StringBuilder stringBuilder = new StringBuilder();
			for (String line : lines) {
				line = line.trim();
				line = line.replace("_", "");
				String outputLine = "@property (nonatomic) " + line + "\n";
				stringBuilder.append(outputLine);
			}
			System.out.print(stringBuilder);
		}
	}

}
