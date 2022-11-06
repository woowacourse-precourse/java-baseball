package baseball;

import java.util.HashSet;
import java.util.Set;

public class UserInputValidation {

    private static final int NUMBER_LENGTH = 3;
    private final String Error_Message = "잘못된 입력값 입니다.";

    public void userInputValidation(String expectedAnswer) {
        if (!isThreeLength(expectedAnswer) || !isInteger(expectedAnswer) || haveZero(expectedAnswer) ||!isNotDuplication(expectedAnswer)) {
            throw new IllegalArgumentException(Error_Message);
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
        throw new IllegalArgumentException(Error_Message);
    }
}
