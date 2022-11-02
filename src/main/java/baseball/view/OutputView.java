package baseball.view;

public class OutputView {
	private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String BALL_MESSAGE = "볼";
	private static final String STRIKE_MESSAGE = "스트라이크";
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String RESTART_OR_EXIT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
		+ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

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

	public static void printEndGame() {
		System.out.println(RESTART_OR_EXIT_MESSAGE);
	}
}
