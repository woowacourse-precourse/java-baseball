package baseball;

public class Message {
	private final String gameStart = "숫자 야구 게임을 시작합니다.";
	private final String inputNumbers = "숫자를 입력해주세요 : ";
	private final String strike = "스트라이크";
	private final String ball = "볼";
	private final String nothing = "낫싱";
	private final String gameOver = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public String getGameStart() {
		return gameStart;
	}

	public String getInputNumbers() {
		return inputNumbers;
	}

	public String getStrike() {
		return strike;
	}

	public String getBall() {
		return ball;
	}

	public String getNothing() {
		return nothing;
	}

	public String getGameOver() {
		return gameOver;
	}
}