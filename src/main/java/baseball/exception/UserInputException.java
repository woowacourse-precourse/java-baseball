package baseball.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputException {

    private static final int VALID_LENGTH = 3;

    public static void checkUserInputException(String userInput) {
        if (isValidLength(userInput) && isNumber(userInput) && isNotContainZero(userInput)
                && isNotDuplicate(userInput)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isValidLength(String userInput) {
        if (userInput.length() == VALID_LENGTH) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(String userInput) {
        for (int userInputIndex = 0; userInputIndex < userInput.length(); userInputIndex++) {
            if (!Character.isDigit(userInput.charAt(userInputIndex))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotContainZero(String userInput) {
        if (userInput.contains("0")) {
            return false;
        }
        return true;
    }

    public static boolean isNotDuplicate(String userInput) {
        List<String> splitUserInput = Arrays.asList(userInput.split(""));
        Set<String> userInputSet = new HashSet<>(splitUserInput);
        if (splitUserInput.size() == userInputSet.size()) {
            return true;
        }
        return false;
    }

    public static void checkUserRestartInputException(String userInput) {
        if (userInput.equals("1") || userInput.equals("2")) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
