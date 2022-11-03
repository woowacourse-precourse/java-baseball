package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputValidator {

	private static final List<String> STANDARD_NUMBER = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
	private static final int MAX_SIZE = 3;
	private InputValidator(){}

	public static void checkUserBallInput(String userBallInput) {
		checkBallNumberLength(userBallInput);
		List<String> splitUserBalls = checkBallNumberIsValidNumber(userBallInput);
		checkDuplicateBalls(splitUserBalls);
	}

	private static void checkBallNumberLength(String userBallInput) {
		if (userBallInput.length() != MAX_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	private static List<String> checkBallNumberIsValidNumber(String userBallInput) {
		String[] splitUserBall = userBallInput.split("");
		for (String ball : splitUserBall) {
			checkStandardNumber(ball);
		}
		return new ArrayList<>(Arrays.asList(splitUserBall));
	}

	private static void checkStandardNumber(String ball) {
		if (!STANDARD_NUMBER.contains(ball)) {
			throw new IllegalArgumentException();
		}
	}

	private static void checkDuplicateBalls(List<String> balls) {
		if (new HashSet<>(balls).size() != MAX_SIZE) {
			throw new IllegalArgumentException();
		}
	}

}
