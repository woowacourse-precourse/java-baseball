package baseball.utils;

import static baseball.constant.GameConstants.*;

import java.util.Arrays;

public class Validator {
	public static void validateNumberInput(String numberInput) throws IllegalArgumentException {
		if (existDuplicateNumber(numberInput) || existInvalidDigits(numberInput) || haveInvalidLength(numberInput)) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateRestartOrNotInput(String input) throws IllegalArgumentException {
		if (!input.equals(RESTART_GAME) && !input.equals(END_GAME)) {
			throw new IllegalArgumentException();
		}
	}

	private static boolean existDuplicateNumber(String numberInput) {
		return Arrays.stream(numberInput.split("")).distinct().count() != numberInput.length();
	}

	private static boolean existInvalidDigits(String numberInput) {
		return Arrays.stream(numberInput.split(""))
			.anyMatch(digit -> !VALID_DIGITS.contains(Integer.parseInt(digit)));
	}

	private static boolean haveInvalidLength(String numberInput) {
		return numberInput.length() != LENGTH_OF_NUMBER;
	}
}
