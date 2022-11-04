package User;

import static baseball.Constant.*;

import java.util.Arrays;

public class Validator {
	public static void validateNumberInput(String numberInput) {
		existDuplicateNumber(numberInput);
		existInvalidLetter(numberInput);
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
}
