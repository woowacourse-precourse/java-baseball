package baseball.verifier;

import baseball.utils.ExceptionMessage;
import baseball.utils.SystemConstant;

public class ControllNumberVerifier implements Verifier {
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
