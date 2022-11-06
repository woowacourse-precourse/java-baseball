package baseball;

public class ValidationUtils {

	private static final int VALID_INPUT_LENGTH = 3;

	public static void validateInput(final String input) {
		if (!isAllDigits(input) || isValidLength(input)) {
			throw new IllegalArgumentException();
		}
	}

	private static boolean isAllDigits(final String input) {
		return input.chars()
			.allMatch(Character::isDigit);
	}

	private static boolean isValidLength(final String input) {
		return input.length() == VALID_INPUT_LENGTH;
	}
}
