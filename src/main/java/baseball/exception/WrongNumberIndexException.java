package baseball.exception;

import baseball.util.message.ExceptionMessage;

public class WrongNumberIndexException extends RuntimeException {
    public WrongNumberIndexException() {
        super(ExceptionMessage.WRONG_NUMBER_INDEX_ERROR.getMessage());
    }
}
