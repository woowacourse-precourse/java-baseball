package baseball.model;

public class RestartOrExitRequest {

	private final int type;

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
