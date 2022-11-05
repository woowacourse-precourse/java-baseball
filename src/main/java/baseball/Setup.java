package baseball;

public enum Setup {

	NUMBER_DIGIT(3);

	private final int value;

	Setup(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
