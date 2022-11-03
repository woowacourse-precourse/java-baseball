package baseball.domain.model;

import java.util.List;
import java.util.Map;

public class Computer {

	private final List<String> computer;

	public Computer(final List<String> computer) {
		this.computer = computer;
	}

	public BallCount compareWithUserBall(String userBall, int userBallIndex) {
		if (this.computer.indexOf(userBall) == userBallIndex) {
			return BallCount.STRIKE;
		}
		if (this.computer.contains(userBall)) {
			return BallCount.BALL;
		}
		return BallCount.OUT;
	}
}
