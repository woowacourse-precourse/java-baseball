package baseball;

public enum CompareResult {
	NOTHING("낫싱"),
	BALL("볼"),
	STRIKE("스트라이크");

	private final String value;

	CompareResult(String value) {
		this.value = value;
	}

	public boolean isStike() {
		return this.equals(STRIKE);
	}

	public boolean isBall() {
		return this.equals(BALL);
	}

	@Override
	public String toString() {
		return value;
	}
}
