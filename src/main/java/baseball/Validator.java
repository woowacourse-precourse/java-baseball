package baseball;

public class Validator {
	public static void validate(String source) {
		if (containsNonNumericValue(source)) {
			throw new IllegalArgumentException("숫자가 아닌 값을 입력할 수 없습니다.");
		}
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
