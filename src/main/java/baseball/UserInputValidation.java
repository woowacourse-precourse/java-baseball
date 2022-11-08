package baseball;

import java.util.HashSet;
import java.util.Set;

import static baseball.Const.ERROR_MESSAGE_NOT_DUPLICATION;
import static baseball.Const.ERROR_MESSAGE_NOT_ZERO;
import static baseball.Const.ERROR_MESSAGE_ONLY_DIGIT;
import static baseball.Const.ERROR_MESSAGE_ONLY_THREE_LENGTH;
import static baseball.Const.ERROR_MESSAGE_RESTART_INPUT;
import static baseball.Const.NUMBER_LENGTH;

public class UserInputValidation {

    public void userInputValidation(String expectedAnswer) {

        if(!isThreeLength(expectedAnswer)){
            throw new IllegalArgumentException(ERROR_MESSAGE_ONLY_THREE_LENGTH);
        }
        if(!isInteger(expectedAnswer)){
            throw new IllegalArgumentException(ERROR_MESSAGE_ONLY_DIGIT);
        }
        if(haveZero(expectedAnswer)){
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_ZERO);
        }
        if(!isNotDuplication(expectedAnswer)){
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DUPLICATION);
        }
    }

    private boolean isThreeLength(String input) {
        if (input.length() == NUMBER_LENGTH) {
            return true;
        }
        return false;
    }

    private boolean isInteger(String input) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {

            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean haveZero(String expectedAnswer) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {

            if ('0' == expectedAnswer.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNotDuplication(String expectedAnswer) {
        Set<Character> inputSet = new HashSet<>();

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            inputSet.add(expectedAnswer.charAt(i));
        }
        if (inputSet.size() == expectedAnswer.length()) {
            return true;
        }
        return false;
    }

    public void restartInputValidation(String input) {
        if ("1".equals(input) || "2".equals(input)) {
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_RESTART_INPUT);
    }
}
