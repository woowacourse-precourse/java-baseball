package baseball.settings;

import static baseball.settings.Constants.*;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static void check(String number) {
        if (!hasThreeDigits(number) || !hasDifferentDigits(number)) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean hasThreeDigits(String number) {
        return number.matches(VALID_NUMBER_REGEX);
    }

    public static boolean hasDifferentDigits(String number) {
        Set<Character> digits = new HashSet<>();
        
        for (char digit : number.toCharArray()) {
            digits.add(digit);
        }
        return digits.size() == NUMBER_OF_DIGITS;
    }
}
