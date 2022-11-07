package baseball.verifier;

import baseball.utils.SystemConstant;

public class ControllNumberVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkLength(input);
        checkRange(input);
    }

    private void checkNumeric(String input) {
        Integer.parseInt(input);
    }

    private void checkLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }
    }
    private void checkRange(String input) {
        int integerInput = Integer.parseInt(input);
        if (integerInput != SystemConstant.GAME_EXIT_CODE &&
            integerInput != SystemConstant.GAME_RESTART_CODE) {
            throw new IllegalArgumentException();
        }
    }
}
