package baseball;

public enum Configure {

	NUMBER_DIGIT(3);

	private int value;

	Configure(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
