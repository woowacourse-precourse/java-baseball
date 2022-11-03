package baseball.domain.model;

public enum BallCount {

	OUT(0,"낫싱"),
	BALL(1, "볼"),
	STRIKE(2, "스트라이크");

	private final int key;
	private final String value;

	BallCount(final int key, final String value) {
		this.key = key;
		this.value = value;
	}
}
