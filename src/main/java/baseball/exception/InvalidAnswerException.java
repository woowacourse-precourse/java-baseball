package baseball.exception;

import static baseball.constant.ErrorMessage.INVALID_ANSWER;

public class InvalidAnswerException extends BaseException {

    public InvalidAnswerException() {
        super(INVALID_ANSWER);
    }
}
