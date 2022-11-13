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

    public static boolean isValidRange(List<String> userInput) {
        boolean isValid = true;

        for (String number : userInput) {
            isValid = isValid && ((Integer.parseInt(number) > 0) && (Integer.parseInt(number) < 10));
        }
        return isValid;
    }

    public static boolean checkDuplication(List<String> userInput) {
        return userInput.stream()
                .distinct()
                .count() == userInput.size();
    }
}
