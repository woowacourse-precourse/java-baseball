package baseball.view;

public class InputView {
	private static final int RESTART_NUMBER = 1;
	private static final int EXIT_NUMBER = 2;
	private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
	private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
	private static final String RESTART_OR_EXIT = String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", RESTART_NUMBER,
		EXIT_NUMBER);

	public static void printGameStart() {
		System.out.println(GAME_START);
	}

	public static void printInputNumber() {
		System.out.print(INPUT_NUMBER);
	}

	public static void printRestartOrExit() {
		System.out.println(RESTART_OR_EXIT);
	}
}
