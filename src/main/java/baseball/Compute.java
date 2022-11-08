package baseball;

import java.util.List;

public class Compute {

	private static final int ZERO = 0;
	private static final int DIGIT_LENGTH = 3;
	private static int strike;
	private static int ball;

	public static boolean computeResult(User user, Opponent opponent) {
		init();
		List<Integer> injectNumber = user.getInjectNumber();
		List<Integer> answer = opponent.getAnswer();

		for (int digitPosition = 0; digitPosition < DIGIT_LENGTH; digitPosition++) {
			int currentDigit = injectNumber.get(digitPosition);
			int findDigit = answer.indexOf(currentDigit); // 추측값의 숫자를 answer의 값에서 찾는다. 있으면 0이상 없으면 -1

			if (findDigit == digitPosition) {
				strike++;
			}
			if (findDigit != digitPosition && findDigit >= 0) {
				ball++;
			}
		}
		print();

		if (strike == DIGIT_LENGTH) {
			return false;
		}
		return true;
	}

	private static void init() {
		strike = ZERO;
		ball = ZERO;
	}

	private static void print() {
		if (strike == ZERO && ball == ZERO) {
			System.out.println("낫싱");
		}
		if (ball == ZERO && strike > ZERO) {
			System.out.println(strike + "스트라이크");
		}
		if (strike == ZERO && ball > ZERO) {
			System.out.println(ball + "볼");
		}
		if (strike > ZERO && ball > ZERO) {
			System.out.println(ball + "볼 " + strike + "스트라이크");
		}
	}
}
