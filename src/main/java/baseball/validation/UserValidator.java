package baseball.validation;

import java.util.HashSet;
import java.util.Set;

public class UserValidator {

    public static boolean restartValidation(String input) {
        return isLengthOne(input) && isOneOrTwo(input);
    }

    public static boolean inputNumberValidation(String input) {
        return isLengthThree(input) && isEachDifferentNumber(input);
    }

    private static boolean isLengthThree(String input) {
        return input.length() == 3;
    }

    private static boolean isEachDifferentNumber(String input) {
        Set<Character> duplicatedCheck = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (isZero(character) || !Character.isDigit(character)) return false;

            duplicatedCheck.add(character);
        }

        return duplicatedCheck.size() == 3;
    }

    private static boolean isZero(char character) {
        return character == '0';
    }

    private static boolean isLengthOne(String input) {
        return input.length() == 1;
    }

    private static boolean isOneOrTwo(String input) {
        int restartNumber = input.charAt(0) - '0';

        return restartNumber == 1 || restartNumber == 2;
    }
}
