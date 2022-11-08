package baseball.exception;

import baseball.message.ErrorMessage;

public class InputWrongReGameNumberException extends BaseballGameException {

    public InputWrongReGameNumberException() {
        super(ErrorMessage.INPUT_WRONG_REGAME_NUMBER);
    }
}
