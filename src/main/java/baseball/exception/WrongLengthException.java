package baseball.exception;


import static baseball.constant.ErrorMessage.WRONG_LENGTH;

public class WrongLengthException extends BaseException {

    public WrongLengthException() {
        super(WRONG_LENGTH);
    }
}
