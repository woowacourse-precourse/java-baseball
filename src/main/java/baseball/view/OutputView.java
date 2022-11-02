package baseball.view;

public class OutputView {
	private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String WIN_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static void gameStartView(){
		System.out.println(START_MESSAGE);
	}

	public static void displayResult(int ball, int strike){
		String ballStr = "";
		String strikeStr = "";
		if (ball > 0){
			ballStr = String.valueOf(ball) + "볼";
		}
		if (strike > 0){
			strikeStr = String.valueOf(strike) + "볼";
		}
		System.out.println(String.join(ballStr, strikeStr));
	}

	public static void displayWin(){
		System.out.println(WIN_MESSAGE);
	}
}
