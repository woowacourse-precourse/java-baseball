package baseball;

public class Validator {

	public static final int PROPER_LENGTH = 3;

	public static void validate(String source) {
		if (containsNonNumericValue(source)) {
			throw new IllegalArgumentException("숫자가 아닌 값을 입력할 수 없습니다.");
		}
		if (isImproperLength(source)) {
			throw new IllegalArgumentException("반드시 세자리 숫자를 입력해야 합니다.");
		}
	}

	private static boolean isImproperLength(String source) {
		return source.length() != PROPER_LENGTH;
	}

	private static boolean containsNonNumericValue(String source) {
		char[] chars = source.toCharArray();
		for (char character : chars) {
			if (!Character.isDigit(character)) {
				return true;
			}
		}
		return false;
	}
}
