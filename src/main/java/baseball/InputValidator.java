package baseball;

public class InputValidator {

	public void validateAnsString(String ansString) throws IllegalArgumentException {
		checkStringLength(ansString);
		checkisNumber(ansString);
	}

	public void checkStringLength(String string) {
		if (string.length() != 3) {
			throw new IllegalArgumentException();
		}
	}

	public void checkisNumber(String string) {
		if (!string.matches("[+-]?\\d*(\\.\\d+)?")) {
			throw new IllegalArgumentException();
		}
	}
}
