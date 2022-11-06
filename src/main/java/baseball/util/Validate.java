package baseball.util;

import java.util.HashSet;
import java.util.Set;

public class Validate {

    public static boolean isRuleDigit(String input) {
        return input.length() == GameRule.NUMBER_OF_NUMBERS;
    }

    public static boolean isDifferentDigits(String digits) {
        Set<Character> countOfNumbers = new HashSet<>();
        for (int indexOfDigits = 0; indexOfDigits < digits.length(); indexOfDigits++) {
            char digit = digits.charAt(indexOfDigits);

            if (countOfNumbers.contains(digit)) {
                return false;
            }

            countOfNumbers.add(digit);

        }
        return true;
    }

    public static boolean isNotContainZero(String digits) {
        for (int indexOfDigits = 0; indexOfDigits < digits.length(); indexOfDigits++) {
            char digit = digits.charAt(indexOfDigits);

            if (digit == '0') {
                return false;
            }

        }
        return true;
    }

}
