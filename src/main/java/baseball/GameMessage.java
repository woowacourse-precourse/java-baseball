package baseball;

public class GameMessage {
	public static final String START_GAME = "숫자 야구 게임을 시작합니다.";
	public static final String ENTER_NUMBER = "숫자를 입력해주세요 : ";
	public static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String QUIT_OR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void startGame() {
		System.out.println(START_GAME);
	}

	public static void enterNumber() {
		System.out.print(ENTER_NUMBER);
	}

	public static void endGame() {
		System.out.println(END_GAME);
	}

	public static void quitOrRestart() {
		System.out.println(QUIT_OR_RESTART);
	}

	public static void informResult(GameResult gameResult) {
		System.out.println(gameResult);
	}
}
