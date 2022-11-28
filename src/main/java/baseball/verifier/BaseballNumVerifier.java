package baseball.verifier;

import baseball.system.ExceptionMessage;
import baseball.system.SystemConstant;
import baseball.utils.StringUtility;

public class BaseballNumVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkThreeDigits(input);
        checkDistinct(input);
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

    private void checkDistinct(String input) {
        if (StringUtility.hasDuplicatedChar(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DISTINCT);
        }
    }
}
