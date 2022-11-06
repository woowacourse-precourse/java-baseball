package baseball.verifier;

import baseball.utils.SystemConstant;

public class NumberVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkThreeDigits(input);
    }

    private void checkNumeric(String input) {
        Integer.parseInt(input);
    }

    private void checkThreeDigits(String input) {
        if (input.length() != SystemConstant.GAME_DIGIT) {
            throw new IllegalArgumentException();
        }
    }
}
