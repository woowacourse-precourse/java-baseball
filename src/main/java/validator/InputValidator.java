package validator;

import java.util.HashSet;
import java.util.Set;

import static constant.BaseballConstant.NUMBER_LENGTH;

public class InputValidator {

    public static boolean isRightInput(String userInput) {
        return isRightLength(userInput) && isRightRange(userInput) && isDuplicate(userInput);
    }

    public static boolean isRightLength(String userInput) {
        return userInput.length() == NUMBER_LENGTH;
    }

    public static boolean isRightRange(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) - '0' < 1 || userInput.charAt(i) - '0' > 9) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDuplicate(String userInput) {
        Set<Character> numbers = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            numbers.add(userInput.charAt(i));
        }
        return numbers.size() == NUMBER_LENGTH;
    }
}
