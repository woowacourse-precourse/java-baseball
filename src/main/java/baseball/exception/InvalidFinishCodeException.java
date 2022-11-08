package baseball.exception;

import static baseball.constant.ErrorMessage.INVALID_FINAL_CODE;

public class InvalidFinishCodeException extends BaseException {

    public InvalidFinishCodeException() {
        super(INVALID_FINAL_CODE);
    }
}
