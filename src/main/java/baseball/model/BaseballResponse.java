package baseball.model;

import static baseball.Constants.*;

public class BaseballResponse {

	private static final String BALL = "볼";
	private static final String STRIKE = "스트라이크";
	private static final String NOTHING = "낫싱";
	private static final int MAX_COUNT = 3;

	private final int strike;
	private final int ball;

	private BaseballResponse(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public static BaseballResponse of(int strike, int ball) {
		return new BaseballResponse(strike, ball);
	}

	public boolean isStrikeOut() {
		return strike == MAX_COUNT;
	}

	public boolean isNothing() {
		return strike == 0 && ball == 0;
	}

	@Override
	public String toString() {
		if (isNothing()) {
			return NOTHING;
		}
		if (isStrikeOut()) {
			return MAX_COUNT + STRIKE;
		}
		final StringBuilder builder = new StringBuilder();
		if (this.ball > 0) {
			builder.append(this.ball);
			builder.append(BALL);
			builder.append(EMPTY);
		}
		if (this.strike > 0) {
			builder.append(this.strike);
			builder.append(STRIKE);
			builder.append(EMPTY);
		}
		return builder.toString().strip();
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

}
