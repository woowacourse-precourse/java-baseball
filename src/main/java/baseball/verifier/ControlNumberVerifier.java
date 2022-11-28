package baseball.verifier;

import baseball.system.ExceptionMessage;
import baseball.system.SystemConstant;

public class ControlNumberVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkRange(input);
    }

    private void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC);
        }
    }

    private void checkRange(String input) {
        int integerInput = Integer.parseInt(input);
        if (integerInput != SystemConstant.GAME_EXIT_CODE &&
                integerInput != SystemConstant.GAME_RESTART_CODE) {
            throw new IllegalArgumentException(ExceptionMessage.UNKNOWN_CONTROL_INPUT);
        }
    }
}
