package baseball.view;

public class OutputView {
	private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String BALL = "볼";
	private static final String STRIKE = "스트라이크";
	private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public void printGameStartMessage(){
		System.out.println(GAME_START_MESSAGE);
	}

	public void printInputMessage(){
		System.out.println(INPUT_MESSAGE);
	}

	public void printRestartMessage(){
		System.out.println(RESTART_MESSAGE);
	}

	public void print3StrikeMessage(){
		System.out.println(THREE_STRIKE_MESSAGE);
		System.out.println(RESTART_MESSAGE);
	}
}
