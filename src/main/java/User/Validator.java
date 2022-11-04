package User;

import java.util.Arrays;

public class Validator {
	public static void validateNumberInput(String numberInput) {
		existDuplicateNumber(numberInput);
	}

	private static void existDuplicateNumber(String numberInput) throws IllegalArgumentException {
		if (Arrays.stream(numberInput.split("")).distinct().count() != numberInput.length()) {
			throw new IllegalArgumentException();
		}
	}
}
