package baseball;

public class InputValidator {

	public void validateAnsString(String ansString) throws IllegalArgumentException {
		checkStringLength(ansString, 3);
		checkIsNumber(ansString);
		checkIsDuplicated(ansString);
		checkStartWithZero(ansString);
	}

	public void validateRestartString(String restartString) throws IllegalArgumentException {

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
		boolean[] used = new boolean[10];
		for (char c : string.toCharArray()) {
			int idx = c-'0';
			if (!used[idx]) {
				used[idx] = true;
				continue;
			}
			throw new IllegalArgumentException();
		}
	}

	private void checkStartWithZero(String string) {
		if (string.charAt(0) == '0') {
			throw new IllegalArgumentException();
		}
	}
}
