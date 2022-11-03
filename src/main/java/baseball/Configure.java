package baseball;

public enum Configure {

	NUMBER_DIGIT(3),

	STRIKE,
	BALL,
	NOTHING,

	RESTART(1),
	END(2);


	private int value;

	Configure(int value) {
		this.value = value;
	}

	Configure() {
	}

	public int getValue() {
		return value;
	}
}
