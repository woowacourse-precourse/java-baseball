package User;

import static baseball.Constant.*;

import java.util.Arrays;

public class Validator {
	public static void validateNumberInput(String numberInput) {
		existDuplicateNumber(numberInput);
		existInvalidLetter(numberInput);
		haveInvalidLength(numberInput);
	}

	public static void validateRestartOrNotInput(String input) throws IllegalArgumentException{
		if (Integer.parseInt(input) != RESTART_GAME && Integer.parseInt(input) != END_GAME) {
			throw new IllegalArgumentException();
		}
	}

	private static void existDuplicateNumber(String numberInput) throws IllegalArgumentException {
		if (Arrays.stream(numberInput.split("")).distinct().count() != numberInput.length()) {
			throw new IllegalArgumentException();
		}
	}

	private static void existInvalidLetter(String numberInput) throws IllegalArgumentException {
		if (Arrays.stream(numberInput.split(""))
			.anyMatch(letter -> !VALID_NUMBERS.contains(Integer.parseInt(letter)))) {
			throw new IllegalArgumentException();
		}
	}

	private static void haveInvalidLength(String numberInput) throws IllegalArgumentException {
		if (numberInput.length() != LENGTH_OF_NUMBER) {
			throw new IllegalArgumentException();
		}
	}
}
