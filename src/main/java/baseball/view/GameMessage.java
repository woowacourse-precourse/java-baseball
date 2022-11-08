package baseball.view;

public class GameMessage {

	public static void printStartMessage() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public static void printEndMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public static void printResultOfInput(int strike, int ball) {
		if (strike == 0 && ball == 0) {
			System.out.println("낫싱");
		}
		if (strike !=0 && ball == 0) {
			System.out.printf("%d스트라이크\n", strike);
		}
		if (strike == 0 && ball != 0) {
			System.out.printf("%d볼\n", ball);
		}
		if (strike !=0 && ball != 0) {
			System.out.printf("%d볼 %d스트라이크\n", ball, strike);
		}
	}
}
