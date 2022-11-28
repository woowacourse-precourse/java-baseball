package baseball.exception;

import baseball.util.message.ExceptionMessage;

public class WrongGameResultException extends RuntimeException {
    public WrongGameResultException() {
        super(ExceptionMessage.WRONG_GAME_RESULT_ERROR.getMessage());
    }
}
