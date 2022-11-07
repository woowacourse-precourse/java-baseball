package baseball;

public class InputValidation {

	public static void validateInput(final String input) {
		if (!isAllDigits(input)) {
			throw new IllegalArgumentException("1에서 9까지의 숫자만 입력가능합니다.");
		}
	}

	private static boolean isAllDigits(final String input) {
		return input.chars()
			.allMatch(Character::isDigit);
	}
}
