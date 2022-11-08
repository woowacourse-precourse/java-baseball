package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {

    private static final int NUMBER_LENGTH = 3;

    public static void userInputRestartValidationCheck(String userInput) {
        if (onlyOneOrTwo(userInput)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void userInputValidationCheck(String userInput) {
        if (isThreeLength(userInput) && isNumber(userInput) && haveNotZero(userInput) && notDuplicatedNumber(userInput)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private static boolean onlyOneOrTwo(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == '1' || userInput.charAt(i) == '2') {
                return true;
            }
        }
        return false;
    }

    private static boolean isThreeLength(String userInput) { // 세자리 수가 넘는 경우
        if (userInput.length() != NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

    private static boolean isNumber(String userInput) { // 숫자가 아닌 값이 있는 경우
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean notDuplicatedNumber(String userInput) { // 숫자가 중복이 되는 경우
        Set<Character> inputSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            inputSet.add(userInput.charAt(i));
        }
        if (inputSet.size() == userInput.length()) {
            return true;
        }
        return false;
    }

    private static boolean haveNotZero(String userInput) { // 문자 중 0이 있는 경우
        for (int i = 0; i < userInput.length(); i++) {
            if ('0' == userInput.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
