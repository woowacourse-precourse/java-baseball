package baseball.view;

public class OutputView {
	public static void printStrikeCount(int strikeCount) {
		System.out.println(strikeCount + "스트라이크");
	}

	public static void printBallCount(int ballCount) {
		System.out.println(ballCount + "볼");
	}

	public static void printNothing() {
		System.out.println("낫싱");
	}

	public static void printBallAndStrikeCount(int ballCount, int strikeCount) {
		System.out.println(ballCount + "볼" + " " + strikeCount + "스트라이크");
	}

	public static void printGameEnd(int strikeOut) {
		String mention = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", strikeOut);
		System.out.println(mention);
	}
}
