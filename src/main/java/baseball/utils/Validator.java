package baseball.utils;

import static baseball.constant.GameConstants.*;

import java.util.Arrays;

public class Validator {
	public static void validateNumberInput(String numberInput) {
		existDuplicateNumber(numberInput);
		existInvalidDigits(numberInput);
		haveInvalidLength(numberInput);
	}

	public static void validateRestartOrNotInput(String input) throws IllegalArgumentException {
		if (!input.equals(RESTART_GAME) && !input.equals(END_GAME)) {
			throw new IllegalArgumentException();
		}
	}

	private static void existDuplicateNumber(String numberInput) throws IllegalArgumentException {
		if (Arrays.stream(numberInput.split("")).distinct().count() != numberInput.length()) {
			throw new IllegalArgumentException();
		}
	}

	private static void existInvalidDigits(String numberInput) throws IllegalArgumentException {
		if (Arrays.stream(numberInput.split(""))
			.anyMatch(digit -> !VALID_DIGITS.contains(Integer.parseInt(digit)))) {
			throw new IllegalArgumentException();
		}
	}

	private static void haveInvalidLength(String numberInput) throws IllegalArgumentException {
		if (numberInput.length() != LENGTH_OF_NUMBER) {
			throw new IllegalArgumentException();
		}
	}
}
