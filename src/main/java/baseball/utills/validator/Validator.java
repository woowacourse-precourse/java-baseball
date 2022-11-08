package baseball.utills.validator;

import baseball.utills.constants.Constants;

import java.util.Arrays;

public class Validator {

    public static boolean validateUserInput(String userInput) throws IllegalArgumentException{
        if (!(isThreelength(userInput) && isUnique(userInput) && isOnlyNumber(userInput))) {
            throw new IllegalArgumentException("입력은 반드시 1~9의 3개의 중복없는 숫자여야 합니다.");
        }
        return true;
    }

    public static boolean isThreelength(String userInput) {
        return userInput.length() == Constants.INPUT_LENGTH;
    }

    public static boolean isUnique(String userInput) {
        return Arrays.stream(userInput.split("")).distinct().count() == Constants.INPUT_LENGTH;
    }

    public static boolean isOnlyNumber(String userInput) {
        return Arrays.stream(userInput.split("")).filter(v -> v.charAt(0) < '1' || v.charAt(0) > '9').count() == 0;
    }

    public static boolean validateOneOrTwo(String userInput) {
        if (!(isOneLength(userInput) && isOneOrTwo(userInput))) {
            throw new IllegalArgumentException("입력 숫자는 반드시 1 또는 2 여야 합니다.");
        }
        return true;
    }

    public static boolean isOneLength(String userInput) {
        return userInput.length() == Constants.RESTART_INPUT_LENGTH;
    }

    public static boolean isOneOrTwo(String userInput) {
        return userInput.charAt(0) == '1' || userInput.charAt(0) == '2';
    }
}
