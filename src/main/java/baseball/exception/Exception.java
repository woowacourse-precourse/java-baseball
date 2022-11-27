package baseball.exception;

import baseball.view.ExceptionMessage;

public enum Exception {
	NUMBER_ONLY_EXCEPTION(new IllegalArgumentException(ExceptionMessage.NUMBER_ONLY_EXCEPTION_MESSAGE.getMessage())),
	LENGTH_EXCEPTION(new IllegalArgumentException(ExceptionMessage.LENGTH_EXCEPTION_MESSAGE.getMessage())),
	GAME_COMMAND_EXCEPTION(new IllegalArgumentException(ExceptionMessage.GAME_COMMAND_EXCEPTION_MESSAGE.getMessage())),
	NUMBER_RANGE_EXCEPTION(new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE_EXCEPTION_MESSAGE.getMessage())),
	SAME_LETTER_EXCEPTION(new IllegalArgumentException(ExceptionMessage.SAME_LETTER_EXCEPTION_MESSAGE.getMessage()));

	private IllegalArgumentException exception;

	Exception(IllegalArgumentException exception) {
		this.exception = exception;
	}

	public IllegalArgumentException getException() {
		return exception;
	}
}
