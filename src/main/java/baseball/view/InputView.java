package baseball.view;

public class InputView {
	private int restartNumber;
	private int exitNumber;
	private final String GAME_START = "숫자 야구 게임을 시작합니다.";
	private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

	public InputView(int restartNumber, int exitNumber) {
		this.restartNumber = restartNumber;
		this.exitNumber = exitNumber;
	}

	public void printGameStart() {
		System.out.println(GAME_START);
	}

	public static void printInputNumber() {
		System.out.print(INPUT_NUMBER);
	}

	public void printRestartOrExit() {
		String restartOtExit = String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", restartNumber, exitNumber);
		System.out.println(restartOtExit);
	}
}
