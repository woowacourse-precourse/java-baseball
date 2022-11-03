package baseball.model.gameresult;

public enum SingleResultType {
	NOTHING("낫싱"),
	BALL("볼"),
	STRIKE("스트라이크");

	private String message;

	SingleResultType(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
