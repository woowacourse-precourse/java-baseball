package baseball;

import java.util.Objects;

public class GameResult {
	private int strike;
	private int ball;

	public GameResult() {
		this.strike = 0;
		this.ball = 0;
	}

	public GameResult(int strike, int ball) {
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
