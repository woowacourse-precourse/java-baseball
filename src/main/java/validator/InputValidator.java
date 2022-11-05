package validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static constant.BaseballConstant.NUMBER_LENGTH;

public class InputValidator {

    public static boolean isRightInput(String userInput) {
        return isRightLength(userInput) && isRightRange(userInput) && isSeparate(userInput);
    }

    public static boolean isRightLength(String userInput) {
        return userInput.length() == NUMBER_LENGTH;
    }

    public static boolean isRightRange(String userInput) {
        return userInput.matches("[1-9]*$");
    }

    public static boolean isSeparate(String userInput) {
        Set<String> numbers = new HashSet<>(Arrays.asList(userInput.split("")));

        return numbers.size() == NUMBER_LENGTH;
    }

    public static boolean isRightExitInput(String exitInput) {
        return exitInput.matches("[1-2]");
    }
}
