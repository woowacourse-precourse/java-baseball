package baseball.exception;

import java.util.Arrays;

public class InputException {
	private static final int NUMBER_COUNT = 3;
	private static final String ONE_LETTER_DIVISION_REGEX = "";
	private static final String NUMBER_REGEX = "^[1-9]*$";

	private void checkNumberCount(String input) {
		if (input.length() != NUMBER_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	private void checkDuplicatedNumber(String input) {
		int distinctNumberCount = (int)Arrays.stream(input.split(ONE_LETTER_DIVISION_REGEX))
			.map(Integer::parseInt)
			.distinct()
			.count();
		if (distinctNumberCount != NUMBER_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	private void checkNumber(String input) {
		if (!input.matches(NUMBER_REGEX)) {
			throw new IllegalArgumentException();
		}
	}


}
