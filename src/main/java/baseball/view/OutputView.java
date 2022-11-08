package baseball.view;

import baseball.domain.UserBall;

public class OutputView {

	public void printUserBallStatus(UserBall userBall) {
		System.out.println(userBall.createUserBallStatusStringDto());
	}

	public void printSuccess() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
