package baseball;

public enum UserResponse {
	RESTART("1"),
	QUIT("2");

	private String value;

	UserResponse(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
