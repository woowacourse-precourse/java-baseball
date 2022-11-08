package baseball;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    public static boolean isValidLength(String input) {
        if (input.length() != Computer.NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

    public static boolean isValidRange(String input) {
        char startRange = Character.forDigit(Computer.START_RANGE, 10);
        char endRange = Character.forDigit(Computer.END_RANGE, 10);
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur < startRange || cur > endRange) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasDuplicateValue(String input) {
        int originalLength = input.length();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        if (set.size() == originalLength) {
            return false;
        }
        return true;
    }
}
