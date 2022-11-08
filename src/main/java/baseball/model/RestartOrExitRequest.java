package baseball.model;

public class RestartOrExitRequest {

	private int type;

	private RestartOrExitRequest(int type) {
		this.type = type;
	}

	public static RestartOrExitRequest of(int type) {
		return new RestartOrExitRequest(type);
	}

	public int getType() {
		return this.type;
	}

}
