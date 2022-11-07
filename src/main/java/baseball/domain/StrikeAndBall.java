package baseball.domain;

public class StrikeAndBall {

	int strike;
	int ball;

	public StrikeAndBall(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}
}
