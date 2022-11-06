package baseball.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputException {

    private final int VALID_LENGTH = 3;

    public boolean isValidLength(String userInput) {
        if (userInput.length() == VALID_LENGTH) {
            return true;
        }
        return false;
    }

    public boolean isNumber(String userInput) {
        for (int userInputIndex = 0; userInputIndex < userInput.length(); userInputIndex++) {
            if (!Character.isDigit(userInput.charAt(userInputIndex))) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotContainZero(String userInput) {
        if (userInput.contains("0")) {
            return false;
        }
        return true;
    }

    public boolean isNotDuplicate(String userInput) {
        List<String> splitUserInput = Arrays.asList(userInput.split(""));
        Set<String> userInputSet = new HashSet<>(splitUserInput);
        if (splitUserInput.size() == userInputSet.size()) {
            return true;
        }
        return false;
    }
}
