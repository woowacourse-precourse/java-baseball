package baseball;

public class InputValidator {

	public void validateAnsString(String ansString) throws IllegalArgumentException {
		checkStringLength(ansString);

	}

	public void checkStringLength(String string) {
		if (string.length() != 3) {
			throw new IllegalArgumentException();
		}
	}

}
