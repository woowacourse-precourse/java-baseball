package baseball.exception;

import baseball.message.ErrorMessage;

public class InputSameNumberException extends BaseballGameException {

    public InputSameNumberException() {
        super(ErrorMessage.INPUT_SAME_NUMBER);
    }
}
