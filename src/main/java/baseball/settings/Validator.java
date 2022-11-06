package baseball.settings;

import static baseball.settings.Constants.*;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static void check(String input) {
        if (!isThreeNumbers(input) || !isAllDifferent(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isThreeNumbers(String input) {
        return input.matches(VALID_NUMBER_REGEX);
    }

    public static boolean isAllDifferent(String input) {
        Set<Character> strToSet = new HashSet<>();
        for (char character : input.toCharArray()) {
            strToSet.add(character);
        }
        return strToSet.size() == NUMBER_OF_DIGITS;
    }
}
