package baseball.exception;

import java.util.Arrays;

import baseball.domain.ConstValue;

public class InputException {
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
		if (input.length() != ConstValue.NUMBER_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	private static void checkDuplicatedNumber(String input) {
		int distinctNumberCount = (int)Arrays.stream(input.split(ConstValue.ONE_LETTER_DIVISION_REGEX))
			.map(Integer::parseInt)
			.distinct()
			.count();
		if (distinctNumberCount != ConstValue.NUMBER_COUNT) {
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

	public static String isRestartOrExitNumber(String input) {
		if (input.equals(ConstValue.RESTART)) {
			return ConstValue.RESTART;
		}
		if (input.equals(ConstValue.EXIT)) {
			return ConstValue.EXIT;
		}
		throw new IllegalArgumentException();
	}
}
