package baseball.service;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    public static boolean isValidNumber(String input) {
        if (input.contains(" ") || input.length() != 3) {
            throw new IllegalArgumentException();
        }
        if (!isNumeric(input)) {
            throw new IllegalArgumentException();
        }
        if (!checkRange(input, 0, 10)) {
            throw new IllegalArgumentException();
        }

        if(!checkDup(input)) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public static boolean isNumeric(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

    public static boolean checkRange(String input, int startRange, int endRange) {
        return input.chars()
                .allMatch(number -> (number - '0') > startRange && (number - '0') < endRange);
    }

    public static boolean checkDup(String input) {
       long dupCount = input.chars()
               .distinct()
               .count();

       return input.length() == dupCount;
    }

    public static boolean isValidReStart(String input) {
        if (input.contains(" ") || input.length() != 1) {
            throw new IllegalArgumentException();
        }

        if (!isNumeric(input)) {
            throw new IllegalArgumentException();
        }

        if (!checkRange(input, 0, 3)) {
            throw new IllegalArgumentException();
        }

        return true;
    }
}
