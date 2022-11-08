package baseball.model;

public class BaseballRequest {

	private final int number;

	private BaseballRequest(int number) {
		this.number = number;
	}

	public static BaseballRequest of(int number) {
		return new BaseballRequest(number);
	}

	public int getNumber() {
		return this.number;
	}

}
