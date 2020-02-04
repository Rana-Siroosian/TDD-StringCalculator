
public class Splitter {
	protected String[] split(String string) {
		String delimiter = extractedDelimiter(string);
		String[] values = extractedValues(string, delimiter);
		return values;
	}

	private String[] extractedValues(String string, String delimiter) {
		if(string.startsWith("//"))
			string = string.substring(4);
		String[] values = string.split(delimiter);
		return values;
	}

	private String extractedDelimiter(String string) {
		
		String delimiter = ",|\n";
		if(string.startsWith("//")) {
			delimiter += "|" + string.substring(2, 3);
		}
		
		return delimiter;
	
	}
}