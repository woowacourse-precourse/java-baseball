package baseball.domain;

import java.util.Objects;

import baseball.util.ViewConst;

public class UserBall {

	private Integer ball;
	private Integer strike;
	private String status;

	public UserBall(Integer ball, Integer strike) {
		this.ball = ball;
		this.strike = strike;
	}

	public static UserBall createUserBall() {
		return new UserBall(0, 0);
	}

	public String createUserBallStatusStringDto() {
		String userBallStatusDto = status + "";
		return userBallStatusDto;
	}

	public boolean is3Strike() {
		return this.status.equals(ViewConst.THREE_STRIKE);
	}

	public void updateBallCount(Integer ball) {
		this.ball = ball;
	}

	public void updateStrikeCount(Integer strike) {
		this.strike = strike;
	}

	public void updateStatus() {

		if (this.strike == 0 && this.ball == 0) {
			this.status = ViewConst.NOTHING;
		}

		if (this.strike == 0 && this.ball != 0) {
			this.status = this.ball + ViewConst.BALL;
		}

		if (this.strike != 0 && this.ball == 0) {
			this.status = this.strike + ViewConst.STRIKE;
		}

		if (this.strike != 0 && this.ball != 0) {
			this.status = this.ball + ViewConst.BALL + " " + this.strike + ViewConst.STRIKE;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserBall userBall = (UserBall)o;
		return Objects.equals(ball, userBall.ball) && Objects.equals(strike, userBall.strike)
			&& Objects.equals(status, userBall.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ball, strike, status);
	}
}
