package baseball;

public class Message {
	public static final String gameStart = "숫자 야구 게임을 시작합니다.";
	public static final String inputNumbers = "숫자를 입력해주세요 : ";
	public static final String strike = "스트라이크";
	public static final String ball = "볼";
	public static final String nothing = "낫싱";
	public static final String gameOver = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static String getNothing() {
		return nothing;
	}

	public static String getGameover() {
		return gameOver;
	}

	public static String getGamestart() {
		return gameStart;
	}

	public static String getInputnumbers() {
		return inputNumbers;
	}

	public static String getStrike() {
		return strike;
	}

	public static String getBall() {
		return ball;
	}

}
