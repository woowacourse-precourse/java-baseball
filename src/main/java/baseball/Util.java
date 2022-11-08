package baseball;

public class Util {
	public static String getDistinctString(String src) {
		char[] chars = src.toCharArray();
		String result = "";
		for (char ch : chars) {
			if (!result.contains(String.valueOf(ch))) {
				result += ch;
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
