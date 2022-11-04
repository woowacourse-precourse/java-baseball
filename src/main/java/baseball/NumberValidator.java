package baseball;

import java.util.HashSet;
import java.util.Set;

public class NumberValidator {
    public static void check(String input) {
        if (!isThreeNumbers(input) || !isAllDifferent(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isThreeNumbers(String input) {
        final String VALID_NUMBER_REGEX = "[1-9]{3}";
        return input.matches(VALID_NUMBER_REGEX);
    }

    public static boolean isAllDifferent(String input) {
        Set<Character> strToSet = new HashSet<>();
        for (char character : input.toCharArray()) {
            strToSet.add(character);
        }
        return strToSet.size() == 3;
    }
}
