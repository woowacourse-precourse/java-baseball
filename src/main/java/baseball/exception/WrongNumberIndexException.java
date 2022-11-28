package baseball.exception;

import baseball.util.ExceptionMessage;

public class WrongNumberIndexException extends RuntimeException {
    public WrongNumberIndexException() {
        super(ExceptionMessage.WRONG_NUMBER_INDEX_ERROR.getMessage());
    }
}
