package baseball.model.gameresult;

public enum ResultType {
	NOTHING("낫싱"),
	BALL("볼"),
	STRIKE("스트라이크");

	private String message;

	ResultType(String message) {
		this.message = message;
	}
}
