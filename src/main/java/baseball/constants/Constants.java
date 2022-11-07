package baseball.constants;

public class Constants {
	
	public static final int NUMBER_MAX_LENGTH = 3;
	public static final int MIN_RANGE = 1;
	public static final int MAX_RANGE = 9;
	
	public static final String inputNumberMessage = "숫자를 입력해 주세요: ";
	public static final String startMessage = "숫자 야구 게임을 시작합니다.";
	public static final String correctMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	
	public static void message(int strike, int ball) {
		if(ball != 0 && strike != 0) {
			System.out.println(ball + "볼 " + strike + "스트라이크");
		}
		if(ball != 0 && strike == 0) {
			System.out.println(ball + "볼");
		}
		if(ball == 0 && strike != 0) {
			System.out.println(strike + "스트라이크");
		}
		if(ball == 0 && strike == 0) {
			System.out.println("낫싱");
		}
	}
}
