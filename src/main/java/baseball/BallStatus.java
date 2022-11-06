package baseball;

public enum BallStatus {
	STRIKE, BALL, NOTHING;

	public boolean isStrikeOrBall() {
		return this == STRIKE || this == BALL;
	}
}
