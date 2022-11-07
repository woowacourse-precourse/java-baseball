package baseball;

public class PrintHandler {

	public static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
	public static final String THREE_STRIKE = "3스트라이크";
	public static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String AGAIN_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void printInputNumber() {
		System.out.print(INPUT_NUMBER);
	}

	public static void printEndGame() {
		System.out.println(THREE_STRIKE);
		System.out.println(GAME_OVER);
	}

	public static void printAgainGame() {
		System.out.println(AGAIN_GAME);
	}

	public static void printHint(String hint) {
		System.out.println(hint);
	}

}
