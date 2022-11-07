package baseball.view;

import baseball.domain.BaseballGameResult;

public class UserOutputView {

	public static void printResult(BaseballGameResult result) {
		if (result.getNumberOfBall() == 0 && result.getNumberOfStrike() == 0) {
			System.out.println("낫싱");
			return;
		}

		StringBuilder output = new StringBuilder();
		if (result.getNumberOfBall() != 0) {
			output.append(result.getNumberOfBall() + "볼 ");
		}
		if (result.getNumberOfStrike() != 0) {
			output.append(result.getNumberOfStrike() + "스트라이크");
		}
		System.out.println(output);
	}

	public static void printFinishPhrase() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

}
