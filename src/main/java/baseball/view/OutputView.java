package baseball.view;

public class OutputView {
	private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String BALL_MESSAGE = "볼 ";
	private static final String STRIKE_MESSAGE = "스트라이크";
	private static final String NO_MATCH_MESSAGE = "낫싱";

	public static void gameStartView(){
		System.out.println(START_MESSAGE);
	}

	public static void tryResultView(int ball, int strike){
		String result = getResult(ball, strike);
		System.out.println(result);
	}

	public static String getResult(int ball, int strike) {
		String result = "";
		if (ball > 0){
			result += ball + BALL_MESSAGE;
		}
		if (strike > 0){
			result += strike + STRIKE_MESSAGE;
		}
		if (result.length() == 0) {
			result = NO_MATCH_MESSAGE;
		}
		return result;
	}

	public static void gameWinView(){
		System.out.println(WIN_MESSAGE);
	}
}
