package baseball;

public class InputValidator {

	public void validateAnsString(String ansString) throws IllegalArgumentException {
		checkStringLength(ansString);
		checkIsNumber(ansString);
		checkIsDuplicated(ansString);
	}

	private void checkStringLength(String string) {
		if (string.length() != 3) {
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
}
