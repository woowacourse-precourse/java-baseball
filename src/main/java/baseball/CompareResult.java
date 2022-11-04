package baseball;

public enum CompareResult {
	NOTHING, BALL, STRIKE;

	public boolean isStike() {
		return this.equals(STRIKE);
	}

	public boolean isBall() {
		return this.equals(BALL);
	}
}
