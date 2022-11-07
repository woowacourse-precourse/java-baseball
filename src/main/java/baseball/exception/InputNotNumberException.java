package baseball.exception;

import baseball.message.ErrorMessage;

public class InputNotNumberException extends BaseballGameException{

    public InputNotNumberException() {
        super(ErrorMessage.INPUT_NOT_NUMBER);
    }
}
