package baseball.exception;

import baseball.common.ErrorMessage;
import baseball.common.GameMessage;

public class Exception {

    public void createNumberInputException(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NOT_INPUT3.getValue());
        }

        if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(2)) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_SAME_INPUT.getValue());
        }

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur < '1' || cur > '9') throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NOT_SCOPE_INPUT.getValue());
        }
    }

    public void restartException(int selectNext) {
        if (selectNext != 1 && selectNext != 2) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NOT_RESTART_INPUT.getValue());
        }
    }

}
