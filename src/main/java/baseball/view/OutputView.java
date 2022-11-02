package baseball.view;

public class OutputView {
	private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String BALL_MESSAGE = "볼";
	private static final String STRIKE_MESSAGE = "스트라이크";
	private static final String NOTHING_MESSAGE = "낫싱";

	public static void printStartGameMessage() {
		System.out.println(GAME_START_MESSAGE);
	}

	public static void printBall(Integer ball) {
		System.out.println(ball + BALL_MESSAGE);
	}

	public static void printStrike(Integer strike) {
		System.out.println(strike + STRIKE_MESSAGE);
	}

	public static void printNothing() {
		System.out.println(NOTHING_MESSAGE);
	}

	public static void printBallAndStrike(Integer ball, Integer strike) {
		System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
	}
}
