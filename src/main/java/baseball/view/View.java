package baseball.view;

public class View {

	public static void showStartGameGuideMessage() {
		System.out.println(GameGuideMessage.START_GAME_GUIDE_MESSAGE);
	}

	public static void showUserInputGuideMessage() {
		System.out.print(GameGuideMessage.USER_INPUT_GUIDE_MESSAGE.getMessage());
	}

	public static void showResult(int ball, int strike, int zero) {
		String result = GameResult.INIT_RESULT.getMessage();

		if (isBall(ball, zero)) {
			result += ball + GameResult.BALL.getMessage();
		}
		if (isStrike(strike, zero)) {
			result += strike + GameResult.STRIKE.getMessage();
		}
		if (isNothing(ball, strike, zero)) {
			result += GameResult.NOTHING.getMessage();
		}

		System.out.println(result);
	}

	private static boolean isNothing(int ball, int strike, int zero) {
		return ball == zero && strike == zero;
	}

	private static boolean isStrike(int strike, int zero) {
		return strike != zero;
	}

	private static boolean isBall(int ball, int zero) {
		return isStrike(ball, zero);
	}

	public static void showThreeStrike() {
		System.out.println(GameGuideMessage.THREE_STRIKE_MESSAGE.getMessage());
	}

	public static void showEndOrRestartGuideMessage() {
		System.out.println(GameGuideMessage.END_OR_RESTART_MESSAGE.getMessage());
	}
}
