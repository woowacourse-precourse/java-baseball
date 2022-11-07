package baseball.view;

public class SystemMessage {
	public String PrintProgress() {
		return "숫자를 입력해주세요 : ";
	}

	public String PrintCount(int strike, int ball) {
		if (strike > 0 && ball > 0) {
			return ball + "볼 " + strike + "스트라이크";
		}
		if (strike > 0 && ball == 0) {
			return strike + "스트라이크";
		}
		if (ball > 0 && strike == 0) {
			return ball + "볼";
		}
		if (strike == 0 && ball == 0) {
			return "낫싱";
		}
		return "";
	}

}