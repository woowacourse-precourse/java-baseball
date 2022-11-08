package baseball.exception;

import baseball.message.Messages;

public class WrongContinueException extends IllegalArgumentException{
    public WrongContinueException() {
        super(Messages.INVALID_CONTINUE_MESSAGE_FORMAT);
    }
}
