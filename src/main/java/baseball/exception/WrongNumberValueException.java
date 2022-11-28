package baseball.exception;

import baseball.util.message.ExceptionMessage;

public class WrongNumberValueException extends RuntimeException {
    public WrongNumberValueException() {
        super(ExceptionMessage.WRONG_NUMBER_VALUE_ERROR.getMessage());
    }
}
