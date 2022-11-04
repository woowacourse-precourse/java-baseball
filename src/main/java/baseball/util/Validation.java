package baseball.util;

import baseball.number.NumberDto;

import java.util.List;

import static baseball.util.Constant.NUMBER_LENGTH;

public abstract class Validation {
    public static boolean validateNumberNotRepeated(NumberDto numberDto) {
        return numberDto
                .getNumber()
                .stream()
                .distinct()
                .count() == NUMBER_LENGTH;
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

    public static boolean validateListSize(List<?> list, int size) {
        return list.size() == size;
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
