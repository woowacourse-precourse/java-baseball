package baseball.domain;

public class UserBall {

	private Integer ball;
	private Integer strike;
	private String status;

	public UserBall(Integer ball, Integer strike) {
		this.ball = 0;
		this.strike = 0;
	}

	public static UserBall createUserBall() {
		return new UserBall(0, 0);
	}

	public Integer getBall() {
		return ball;
	}

	public Integer getStrike() {
		return strike;
	}

	public String getStatus() {
		return status;
	}

	public void changeBallCount(Integer ball) {
		this.ball = ball;
	}

	public void changeStrikeCount(Integer strike) {
		this.strike = strike;
	}

	public void updateStatus() {
		if (this.strike == 3) {
			this.status = this.strike + "스트라이크";
			return;
		}

		if (this.strike == 0 && this.ball == 0) {
			this.status = "낫싱";
		}

		if (this.strike == 0 && this.ball != 0) {
			this.status = this.ball + "볼";
		}

		if (this.strike != 0 && this.ball == 0) {
			this.status = this.strike + "스트라이크";
		}

		if (this.strike != 0 && this.ball != 0) {
			this.status = this.ball + "볼 " + this.strike + "스트라이크";
		}
	}
}
