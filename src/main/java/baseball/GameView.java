package baseball;

public class GameView {
	private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
	private static final String INPUT_INSTRUCTION = "숫자를 입력해주세요 : ";
	private static final String STRIKE = "스트라이크";
	private static final String BALL = "볼";
	private static final String NOTHING = "낫싱";
	private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String RESTART = "1";
	private static final String END = "2";

	public static void printStartGame() {
		System.out.println(START_GAME);
	}

	public static void printInstruction() {
		System.out.print(INPUT_INSTRUCTION);
	}

	public static void printStrike(int strikeCount) {
		System.out.print(strikeCount + STRIKE);
	}

	public static void printBall(int ballCount) {
		System.out.print(ballCount + BALL);
	}

	public static void printBallAndStrike(int ballCount) {
		System.out.print(ballCount + BALL + " ");
	}

	public static void printNothing() {
		System.out.println(NOTHING);
	}

	public static void printEndGame() {
		System.out.println(END_GAME);
	}

	public static void printRestartGame() {
		System.out.println(RESTART_GAME);
	}

	public static boolean isRestart(String input) {
		return input.equals(RESTART);
	}

	public static boolean isEnd(String input) {
		return input.equals(END);
	}
}


