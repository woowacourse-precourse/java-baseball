package baseball.domain;

public class UserBall {

	private Integer ball;
	private Integer strike;

	public UserBall(Integer ball, Integer strike) {
		this.ball = 0;
		this.strike = 0;
	}

	public Integer getBall() {
		return ball;
	}

	public Integer getStrike() {
		return strike;
	}

	public void changeBallCount(Integer ball) {
		this.ball = ball;
	}

	public void changeStrikeCount(Integer strike) {
		this.strike = strike;
	}
}
