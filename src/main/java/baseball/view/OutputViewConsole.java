package baseball.view;

public class OutputViewConsole implements OutputView {
	private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String GET_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String BALL_MESSAGE = "볼 ";
	private static final String STRIKE_MESSAGE = "스트라이크";
	private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final int BALL = 0;
	private static final int STRIKE = 1;

	@Override
	public void printGameStartMessage() {
		System.out.println(GAME_START_MESSAGE);
	}

	@Override
	public void printInputMessage() {
		System.out.print(GET_INPUT_MESSAGE);
	}

	@Override
	public void printRestartMessage() {
		System.out.println(RESTART_MESSAGE);
	}

	@Override
	public void print3StrikeMessage() {
		System.out.println(THREE_STRIKE_MESSAGE);
	}

	@Override
	public void printBSOResult(int[] resultBSO) {
		if (resultBSO[BALL] == 0 && resultBSO[STRIKE] == 0) {
			System.out.println("낫싱");
			return;
		}
		if (resultBSO[BALL] != 0)
			System.out.print(resultBSO[BALL] + BALL_MESSAGE);
		if (resultBSO[STRIKE] != 0)
			System.out.print(resultBSO[STRIKE] + STRIKE_MESSAGE);
		System.out.println();
	}
}
