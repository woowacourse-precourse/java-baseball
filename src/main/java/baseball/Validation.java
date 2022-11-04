package baseball;

import java.util.List;

public class Validation {
    public static boolean isValidLength(List<String> userInput) {
        return userInput.size() == 3;
    }

    public static boolean isExistOnlyNumber(List<String> userInput) {
        boolean isOnlyNumber = false;

        for (String element : userInput) {
            isOnlyNumber = isOnlyNumber || Character.isDigit(element.charAt(0));
        }
        return isOnlyNumber;
    }
}
