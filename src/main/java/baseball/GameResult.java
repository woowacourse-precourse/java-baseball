package baseball;

import java.util.Objects;

public class GameResult {
	public static final int NO_STRIKE = 0;
	public static final int NO_BALL = 0;
	public static final int STRIKE_OUT = 3;
	public static final String BLANK = " ";

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

	public static GameResult createEmpty() {
		return new GameResult();
	}

	public void addStrike() {
		strike++;
	}

	public void addBall() {
		ball++;
	}

	public boolean isAnswer() {
		return strike == STRIKE_OUT;
	}

	private boolean hasNothing() {
		return !hasBall() && !hasStrike();
	}

	private boolean hasStrike() {
		return strike > NO_STRIKE;
	}

	private boolean hasBall() {
		return ball > NO_BALL;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		if (hasNothing()) {
			return CompareResult.NOTHING.toString();
		}
		if (hasBall()) {
			stringBuilder.append(ball).append(CompareResult.BALL).append(BLANK);
		}
		if (hasStrike()) {
			stringBuilder.append(strike).append(CompareResult.STRIKE);
		}
		return stringBuilder.toString().trim();
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
