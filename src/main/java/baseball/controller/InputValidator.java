package baseball.controller;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static final int INPUT_LENGTH = 3;

    public static void checkIsValidRestartExitString(String userInput) {
        if (userInput.length() != 1 || !(userInput.charAt(0) == '1' || userInput.charAt(0) == '2')
                || !Character.isDigit(userInput.charAt(0))) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkIsValidThreeNumbers(String userInput) {
        if (userInput.length() != INPUT_LENGTH || !checkIsValidChar(userInput) || checkIsDuplicated(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    private static Boolean checkIsValidChar(String userInput) {
        for (char c : userInput.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIsDuplicated(String userInput) {
        Set<Integer> inputNumbers = new HashSet<>();

        for (String s : userInput.split("")) {
            inputNumbers.add(Integer.parseInt(s));
        }
        return inputNumbers.size() != INPUT_LENGTH;
    }
}
