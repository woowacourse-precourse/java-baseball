package baseball;

import java.util.stream.IntStream;

public class InputValidator {

	public void validateAnsString(String ansString) throws IllegalArgumentException {
		checkStringLength(ansString, 3);
		checkIsNumber(ansString);
		checkIsDuplicated(ansString);
		checkStartWithZero(ansString);
	}

	public void validateRestartString(String restartString) throws IllegalArgumentException {
		checkOneOrTwo(restartString);
	}

	private void checkStringLength(String string, int length) {
		if (string.length() != length) {
			throw new IllegalArgumentException();
		}
	}

	private void checkIsNumber(String string) {
		if (!string.matches("[+-]?\\d*(\\.\\d+)?")) {
			throw new IllegalArgumentException();
		}
	}

	private void checkIsDuplicated(String string) {
		IntStream intStream = string.chars();
		int distinct = (int)intStream.distinct().count();
		if (distinct != string.length()) {
			throw new IllegalArgumentException();
		}
	}

	private void checkStartWithZero(String string) {
		if (string.charAt(0) == '0') {
			throw new IllegalArgumentException();
		}
	}

	private void checkOneOrTwo(String string) {
		if (!(string.equals("1") || string.equals("2"))) {
			throw new IllegalArgumentException();
		}
	}
}
