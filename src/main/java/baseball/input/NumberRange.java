package baseball.input;

public enum NumberRange {
	MIN(1), MAX(9);

	private int number;

	NumberRange(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
