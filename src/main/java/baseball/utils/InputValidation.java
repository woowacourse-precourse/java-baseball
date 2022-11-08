package baseball.utils;

public class InputValidation {

	public static void validateIsAllDigit(final String input) {
		if (!isAllDigits(input)) {
			throw new IllegalArgumentException("숫자만 입력가능합니다.");
		}
	}

	private static boolean isAllDigits(final String input) {
		return input.chars()
			.allMatch(Character::isDigit);
	}
}
