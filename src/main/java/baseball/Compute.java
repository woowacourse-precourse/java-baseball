package baseball;

import java.util.List;

public class Compute {
	private static final int ZERO = 0;
	private static final int DIGIT_LENGTH = 3;
	private static int strike;
	private static int ball;

	public static void computeResult(User user, Opponent opponent) {
		init();
		List<Integer> injectNumber = user.getInjectNumber();
		List<Integer> answer = opponent.getAnswer();

		for (int digitPosition = 0; digitPosition < DIGIT_LENGTH; digitPosition++) {
			int currentDigit = injectNumber.get(digitPosition);
			int findDigit = answer.indexOf(currentDigit);

			if (findDigit == digitPosition) {
				strike++;
			}
			if (findDigit != digitPosition && findDigit >= 0) {
				ball++;
			}
		}
	}

	private static void init() {
		strike = ZERO;
		ball = ZERO;
	}
}
