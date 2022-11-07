package baseball;

import static baseball.Constants.*;

import java.util.List;

public class InputException extends IllegalArgumentException {
	public InputException() {
	}

	public static void checkNotNumber(String input) {
		if (!input.matches(ONLY_NUM)) {
			throw new IllegalArgumentException(NOT_NUMBER);
		}
	}

	public static void checkLength(String input) {
		if (input.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException(NOT_THREE_DIGIT);
		}
	}

	public static void checkDuplicate(List<Integer> input) {
		if (hasDuplicatedNum(input)) {
			throw new IllegalArgumentException(DUPLICATED_NUMBER);
		}
	}

	private static boolean hasDuplicatedNum(List<Integer> input) {
		return input.get(0).equals(input.get(1)) || input.get(0).equals(input.get(2)) || input.get(1)
			.equals(input.get(2));
	}

	public static void checkZero(List<Integer> input) {
		if (input.contains(ZERO)) {
			throw new IllegalArgumentException(ZERO_INPUT);
		}
	}

	public static void checkNotOneOrTwo(String input) {
		if (!input.equals(RESTART) && !input.equals(END)) {
			throw new IllegalArgumentException(NOT_ONE_TWO);
		}
	}
}
