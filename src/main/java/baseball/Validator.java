package baseball;

import static baseball.NumericalCondition.*;

import java.util.HashSet;

public class Validator {
	public static void validateBallsInput(String source) {
		validateOnlyNumeric(source);
		validateProperLength(source);
		validateDigitsNotDuplicated(source);
	}

	public static void validateQuitOrRestartInput(String source) {
		if (!source.equals(UserResponse.RESTART.getValue()) && !source.equals(UserResponse.QUIT.getValue())) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_QUIT_OR_RESTART_INPUT);
		}
	}

	private static void validateDigitsNotDuplicated(String source) {
		if (hasDuplicatedDigit(source)) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATED_DIGITS);
		}
	}

	private static void validateProperLength(String source) {
		if (isImproperLength(source)) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH);
		}
	}

	private static void validateOnlyNumeric(String source) {
		if (containsNonNumericValue(source)) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_INPUT);
		}
	}

	private static boolean hasDuplicatedDigit(String source) {
		HashSet<Character> uniqueDigits = new HashSet<>();
		char[] digits = source.toCharArray();
		for (char digit : digits) {
			uniqueDigits.add(digit);
		}
		return uniqueDigits.size() != PROPER_LENGTH;
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
