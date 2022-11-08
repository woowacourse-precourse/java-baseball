package baseball.util;

import java.util.List;

public abstract class Validation {
    public static boolean validateNumberNotRepeated(List<Integer> numbers, int numbersSize) {
        return numbers
                .stream()
                .distinct()
                .count() == numbersSize;
    }

    public static <T> boolean validateNotNull(T object) {
        return object != null;
    }

    public static boolean validateStringNotEmpty(String string) {
        return !string.equals("");
    }

    public static boolean validateStringLength(String string, int length) {
        return string.length() == length;
    }

    public static boolean validateIntegerRange(int integer, int minValue, int maxValue) {
        return integer >= minValue
                && integer <= maxValue;
    }

    public static <T> boolean isInteger(T input) {
        try {
            Integer.parseInt((String) input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
