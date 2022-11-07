package baseball.utils;

public enum Game {
	size(3),
	min(1),
	max(9),
	nothing(0),
	strike(1),
	ball(2),
	root(0);
	private final int value;

	public int getValue() {
		return value;
	}

	Game(int result) {
		this.value = result;
	}

}
