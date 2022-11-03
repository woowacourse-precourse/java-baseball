package baseball.view;

import baseball.domain.UserBall;

public class OutputView {

	public void printStrike(UserBall userBall) {
		System.out.printf("%d스트라이크\n", userBall.getStrike());
	}

	public void printBall(UserBall userBall) {
		System.out.printf("%d볼\n", userBall.getBall());
	}

	public void printNothing() {
		System.out.println("낫싱");
	}

	public void printSuccess() {
		System.out.println("3스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public void printBallAndStrike(UserBall userBall) {
		System.out.printf("%d볼 %d스트라이크\n", userBall.getBall(), userBall.getStrike());
	}

}
