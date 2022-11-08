package baseball.exception;

import baseball.message.ErrorMessage;

public class InputNotNumberOrZeroException extends BaseballGameException{

    public InputNotNumberOrZeroException() {
        super(ErrorMessage.INPUT_NOT_NUMBER_OR_ZERO);
    }
}
