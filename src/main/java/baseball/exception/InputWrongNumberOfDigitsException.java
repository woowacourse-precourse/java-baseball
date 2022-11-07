package baseball.exception;

import baseball.message.ErrorMessage;

public class InputWrongNumberOfDigitsException extends BaseballGameException {

    public InputWrongNumberOfDigitsException() {
        super(ErrorMessage.WRONG_NUMBER_OF_DIGITS);
    }
}
