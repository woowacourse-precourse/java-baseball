package baseball;

import java.util.HashSet;

public class Validator {
	public static final int PROPER_LENGTH = 3;
	public static final String INVALID_QUIT_OR_RESTART_INPUT = "반드시 1 또는 2를 입력해주세요.";
	public static final String DUPLICATED_DIGITS = "서로 중복되지 않는 세자리 숫자를 입력해주세요.";
	public static final String INVALID_LENGTH = "반드시 세자리 숫자를 입력해야 합니다.";
	public static final String NOT_NUMERIC_INPUT = "숫자가 아닌 값을 입력할 수 없습니다.";

	public static void validateBallsInput(String source) {
		validateOnlyNumeric(source);
		validateProperLength(source);
		validateDigitsNotDuplicated(source);
	}

	public static void validateQuitOrRestartInput(String source) {
		if (!source.equals(UserResponse.RESTART.getValue()) && !source.equals(UserResponse.QUIT.getValue())) {
			throw new IllegalArgumentException(INVALID_QUIT_OR_RESTART_INPUT);
		}
	}

	private static void validateDigitsNotDuplicated(String source) {
		if (hasDuplicatedDigit(source)) {
			throw new IllegalArgumentException(DUPLICATED_DIGITS);
		}
	}

	private static void validateProperLength(String source) {
		if (isImproperLength(source)) {
			throw new IllegalArgumentException(INVALID_LENGTH);
		}
	}

	private static void validateOnlyNumeric(String source) {
		if (containsNonNumericValue(source)) {
			throw new IllegalArgumentException(NOT_NUMERIC_INPUT);
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
