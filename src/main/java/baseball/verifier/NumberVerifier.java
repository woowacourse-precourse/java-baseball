package baseball.verifier;

import baseball.system.ExceptionMessage;
import baseball.system.SystemConstant;

public class NumberVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkThreeDigits(input);
    }

    private void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC);
        }
    }

    private void checkThreeDigits(String input) {
        if (input.length() != SystemConstant.GAME_DIGIT) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_THREE_DIGITS);
        }
    }
}
