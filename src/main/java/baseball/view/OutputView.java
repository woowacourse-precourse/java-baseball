package baseball.view;

public class OutputView {
	private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String WIN_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String BALL_MESSAGE = "볼 ";
	private static final String STRIKE_MESSAGE = "스트라이크";
	private static final String NO_MATCH_MESSAGE = "낫싱";

	public static void gameStartView(){
		System.out.println(START_MESSAGE);
	}

	public static void displayResult(int ball, int strike){
		String result = "";
		if (ball > 0){
			result += String.valueOf(ball) + BALL_MESSAGE;
		}
		if (strike > 0){
			result += String.valueOf(strike) + STRIKE_MESSAGE;
		}
		if (result.length() == 0) {
			System.out.println(NO_MATCH_MESSAGE);
		} else {
			System.out.println(result);
		}
	}

	public static void displayWin(){
		System.out.println(WIN_MESSAGE);
	}

	public static void displayRestartMessage(){
		System.out.println(RESTART_MESSAGE);
	}
}
