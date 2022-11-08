package baseball.exception;

import baseball.message.Messages;

public class WrongNumberDigitException extends IllegalArgumentException{
    public WrongNumberDigitException() {
        super(Messages.INVALID_INTEGER_LENGTH_MESSAGE);
    }
}
