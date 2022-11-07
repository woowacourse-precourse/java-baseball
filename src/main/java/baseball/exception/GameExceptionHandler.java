package baseball.exception;

public class GameExceptionHandler {
	public static void handleNotNumberException(String input) throws IllegalArgumentException {
		if (input.matches("^[1-9]{3}$") == false) {
			throw new IllegalArgumentException("Input is not number.");
		}
	}

	public static void handleEmptyException(String input) throws IllegalArgumentException {
		if (input.isEmpty() == true) {
			throw new IllegalArgumentException("Input is empty.");
		}
	}
}
