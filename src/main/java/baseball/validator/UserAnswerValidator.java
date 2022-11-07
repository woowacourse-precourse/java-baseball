package baseball.validator;

import static baseball.enums.AsciiType.ASCII_NINE;
import static baseball.enums.AsciiType.ASCII_ONE;

import baseball.message.ErrorMessage;

public class UserAnswerValidator {
    private static final int CORRECT_LENGTH = 3;
    private static final int FIRST_NUMBER = 0;
    private static final int SECOND_NUMBER = 1;
    private static final int THIRD_NUMBER = 2;

    public void validateUserAnswer(String userAnswer) {
        if (!checkNumber(userAnswer)) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_INPUT_EXCEPTION);
        }
        if (!checkLength(userAnswer)) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_LENGTH_EXCEPTION);
        }
        if (!checkSameNumber(userAnswer)) {
            throw new IllegalArgumentException(ErrorMessage.SAME_NUMBER_EXCEPTION);
        }
    }

    private boolean checkSameNumber(String userAnswer) {
        return userAnswer.charAt(FIRST_NUMBER) != userAnswer.charAt(SECOND_NUMBER)
                && userAnswer.charAt(FIRST_NUMBER) != userAnswer.charAt(THIRD_NUMBER)
                && userAnswer.charAt(SECOND_NUMBER) != userAnswer.charAt((THIRD_NUMBER));
    }

    private boolean checkLength(String userAnswer) {
        return userAnswer.length() == CORRECT_LENGTH;
    }

    private boolean checkNumber(String userAnswer) {
        if (userAnswer.charAt(FIRST_NUMBER) < ASCII_ONE.getAsciiNumber()
                || userAnswer.charAt(FIRST_NUMBER) > ASCII_NINE.getAsciiNumber()) {
            return false;
        }
        if (userAnswer.charAt(SECOND_NUMBER) < ASCII_ONE.getAsciiNumber()
                || userAnswer.charAt(SECOND_NUMBER) > ASCII_NINE.getAsciiNumber()) {
            return false;
        }
        return userAnswer.charAt(THIRD_NUMBER) >= ASCII_ONE.getAsciiNumber()
                && userAnswer.charAt(THIRD_NUMBER) <= ASCII_NINE.getAsciiNumber();
    }
}
