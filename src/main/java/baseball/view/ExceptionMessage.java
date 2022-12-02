package baseball.view;

public enum ExceptionMessage {
	NUMBER_ONLY_EXCEPTION_MESSAGE("[ERROR] 숫자만 입력해주세요"),
	LENGTH_EXCEPTION_MESSAGE("[ERROR] 올바른 길이의 숫자를 입력해주세요"),
	NUMBER_RANGE_EXCEPTION_MESSAGE("[ERROR] 1~9 사이의 숫자만 입력 가능합니다"),
	SAME_LETTER_EXCEPTION_MESSAGE("[ERROR] 중복되는 숫자는 입력할 수 없습니다"),
	GAME_COMMAND_EXCEPTION_MESSAGE("[ERROR] 1혹은 2를 입력해주세요");

	private String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
