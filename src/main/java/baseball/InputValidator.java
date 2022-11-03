package baseball;

import java.util.List;

public class InputValidator {

	private static final List<String> STANDARD_NUMBER = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");

	private InputValidator(){}

	public static void checkUserBallInput(String userBallInput) {
		checkBallNumberLength(userBallInput);
	}

	private static void checkBallNumberLength(String userBallInput) {
		if (userBallInput.length() != 3) {
			throw new IllegalArgumentException();
		}
	}
}
