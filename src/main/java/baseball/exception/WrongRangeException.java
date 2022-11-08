package baseball.exception;

import static baseball.constant.ErrorMessage.WRONG_RANGE;

public class WrongRangeException extends BaseException {

    public WrongRangeException() {
        super(WRONG_RANGE);
    }
}
