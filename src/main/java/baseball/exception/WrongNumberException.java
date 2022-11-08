package baseball.exception;

import baseball.message.Messages;

public class WrongNumberException extends  IllegalArgumentException{
    public WrongNumberException() {
        super(Messages.INVALID_BASEBALL_NUMBER_RANGE);
    }
}
