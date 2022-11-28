package baseball.exception;

import baseball.util.ExceptionMessage;

public class DuplicateNumberException extends RuntimeException {

    public DuplicateNumberException() {
        super(ExceptionMessage.DUPLICATE_NUMBER_ERROR.getMessage());
    }
}
