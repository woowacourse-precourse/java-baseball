package baseball;

import static constant.Constant.*;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    public static void checkInput(String input) {
        if (!isThreeLength(input) || !isInRange(input) || !isNotDuplicate(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static boolean isThreeLength(String input) {
        return (input.length() == MAX_LENGTH);
    }

    private static boolean isInRange(String input) {
        for (char number : input.toCharArray()) {
            if (number > '1' && number < '9') {
                return true;
            }
        }
        return false;
    }

    private static boolean isNotDuplicate(String input) {
        Set<Character> value = new HashSet<>();
        for (char number : input.toCharArray()) {
            value.add(number);
        }
        return (value.size() == MAX_LENGTH);
    }

    public static void isRestartOrEnd(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}