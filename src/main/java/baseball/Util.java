package baseball;

public class Util {
	public static String getDistinctString(String src){
		char[] chars = src.toCharArray();
		String result = "";
		for (char ch : chars){
			if (!result.contains(String.valueOf(ch))){
				result += ch;
			}
		}
		return result;
	}
}
