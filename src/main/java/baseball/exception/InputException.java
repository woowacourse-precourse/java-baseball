package baseball.exception;

import java.util.Arrays;

public class InputException {
	private static final int NUMBER_COUNT = 3;
	private static final String ONE_LETTER_DIVISION_REGEX = "";
	private static final String NUMBER_REGEX = "^[1-9]*$";
	private static final String ZERO_NUMBER = "0";

	public static String checkNumberForm(String input) {
		checkNumberCount(input);
		checkDuplicatedNumber(input);
		isNumber(input);
		containZeroNumber(input);
		return input;
	}

	private static void checkNumberCount(String input) {
		if (input.length() != NUMBER_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	private static void checkDuplicatedNumber(String input) {
		int distinctNumberCount = (int)Arrays.stream(input.split(ONE_LETTER_DIVISION_REGEX))
			.map(Integer::parseInt)
			.distinct()
			.count();
		if (distinctNumberCount != NUMBER_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	private static void isNumber(String input) {
		if (!input.matches(NUMBER_REGEX)) {
			throw new IllegalArgumentException();
		}
	}

	private static void containZeroNumber(String input) {
		if (input.contains(ZERO_NUMBER)) {
			throw new IllegalArgumentException();
		}
	}
}
