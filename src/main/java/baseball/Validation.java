package baseball;

import java.util.List;

public class Validation {
    public static boolean isValidLength(List<String> userInput, int length) {
        return userInput.size() == length;
    }

    public static boolean hasOnlyNumber(List<String> userInput) {
        boolean isOnlyNumber = true;

        for (String element : userInput) {
            isOnlyNumber = isOnlyNumber && Character.isDigit(element.charAt(0));
        }
        return isOnlyNumber;
    }
}
