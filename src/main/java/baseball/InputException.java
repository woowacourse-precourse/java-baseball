package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputException {
    private static final String INVALID_INPUT_NUMBER_ERROR_MESSAGE = "ERROR!! 정상적인 값이 아닙니다. 게임을 종료합니다.";
    private static int NUMBER_LENGTH = 3;

    public static void checkInputNumberValidation(String number) {
        if (isThreeLength(number) && isInteger(number) && hasNotZero(number) && hasNotDuplicate(number)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_INPUT_NUMBER_ERROR_MESSAGE);
    }

    public static boolean isThreeLength(String number) {
        if (number.length() == NUMBER_LENGTH) {
            return true;
        }
        return false;
    }

    public static boolean isInteger(String number) {
        for (int digit = 0; digit < NUMBER_LENGTH; digit++) {
            if (!Character.isDigit(number.charAt(digit))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasNotZero(String number) {
        for (int digit = 0; digit < NUMBER_LENGTH; digit++) {
            if ('0' == number.charAt(digit)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasNotDuplicate(String number) {
        Set<Character> numberSet = new HashSet<>();
        for (int digit = 0; digit < NUMBER_LENGTH; digit++) {
            numberSet.add(number.charAt(digit));
        }
        if (NUMBER_LENGTH == numberSet.size()) {
            return true;
        }
        return false;
    }
}
