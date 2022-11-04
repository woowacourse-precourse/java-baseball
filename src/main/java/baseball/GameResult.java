package baseball;

import java.util.Objects;

public class GameResult {
	public static final int NO_STRIKE = 0;
	public static final int NO_BALL = 0;

	private int strike;
	private int ball;

	public GameResult() {
		this.strike = NO_STRIKE;
		this.ball = NO_BALL;
	}

	protected GameResult(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public void addStrike() {
		strike++;
	}

	public void addBall() {
		ball++;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		GameResult that = (GameResult)o;
		return strike == that.strike && ball == that.ball;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strike, ball);
	}
}
