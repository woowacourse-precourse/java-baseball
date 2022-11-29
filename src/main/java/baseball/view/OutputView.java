package baseball.view;

public class OutputView {
	public static String result;
	public static int NO_BALL = 0;
	public static int NO_STRIKE = 0;

	public static void showResult(int ball, int strike) {
		result = GameResult.INIT_RESULT.getMessage();

		ball(ball);
		strike(strike);
		nothing(ball, strike);

		System.out.println(result);
	}

	private static void nothing(int ball, int strike) {
		if (isNothing(ball, strike)) {
			result += GameResult.NOTHING.getMessage();
		}
	}

	private static void strike(int strike) {
		if (isStrike(strike)) {
			result += strike + GameResult.STRIKE.getMessage();
		}
	}

	private static void ball(int ball) {
		if (isBall(ball)) {
			result += ball + GameResult.BALL.getMessage();
		}
	}

	private static boolean isNothing(int ball, int strike) {
		return ball == NO_BALL && strike == NO_STRIKE;
	}

	private static boolean isStrike(int strike) {
		return strike != NO_STRIKE;
	}

	private static boolean isBall(int ball) {
		return ball != NO_BALL;
	}

	public static void showThreeStrike() {
		System.out.println(GameGuideMessage.THREE_STRIKE_MESSAGE.getMessage());
	}

	public static void showExceptionMessage(IllegalArgumentException exception) {
		System.out.println(exception.getMessage());
	}
}
