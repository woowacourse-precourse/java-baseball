package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void checkIsValidRestartExitString(String userInput) {
        if (userInput.length() != 1) {
            throw new IllegalArgumentException();
        }
        if (!Character.isDigit(userInput.charAt(0))) {
            throw new IllegalArgumentException();
        }
        if (!(userInput.charAt(0) == '0' || userInput.charAt(0) == '1')) {
            throw new IllegalArgumentException();
        }
    }
    public static void checkIsValidThreeNumbers(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        if (checkIsDuplicated(userInput)) {
            throw new IllegalArgumentException();
        }
    }


    private static boolean checkIsDuplicated(String userInput) {
        Set<Integer> inputNumbers = new HashSet<>();

        for (int i = 0; i < userInput.length(); i++) {
            inputNumbers.add(Integer.parseInt(userInput.substring(i, i + 1)));
        }
        if (inputNumbers.size() != 3) {
            return true;
        }
        return false;
    }
}
