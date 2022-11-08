package baseball.exception;

import static baseball.constant.ErrorMessage.NOT_DISTINCT;

public class NotDistinctException extends BaseException {

    public NotDistinctException() {
        super(NOT_DISTINCT);
    }
}
