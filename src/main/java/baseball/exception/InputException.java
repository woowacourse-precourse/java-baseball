package baseball.exception;

public class InputException {
	private static final int NUMBER_COUNT = 3;

	private void checkNumberCount(String input) {
		if (input.length() != NUMBER_COUNT) {
			throw new IllegalArgumentException();
		}
	}
}
