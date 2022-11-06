package baseball;

public enum BallStatus {
	STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

	private final String status;

	BallStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public boolean isStrikeOrBall() {
		return this == STRIKE || this == BALL;
	}
}
