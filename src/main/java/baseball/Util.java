package baseball;

public class Util {
	public static String getDistinctString(String src) {
		char[] charArray = src.toCharArray();
		String result = "";
		for (char word : charArray) {
			if (!result.contains(String.valueOf(word))) {
				result += word;
			}
		}
		return result;
	}

	public static boolean isStringContainChar(String dec, char ch) {
		return dec.contains(String.valueOf(ch));
	}

	public static boolean isStringContainInt(String dec, int num) {
		return dec.contains(String.valueOf(num));
	}
}
