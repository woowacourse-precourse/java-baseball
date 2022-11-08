package baseball.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public final static String RESTART = "1";
    public final static String EXIT = "2";
    public final static Integer BASEBALL_INPUT_LENGTH = 3;

    public static void checkBaseballInput(String baseballInput) {
        checkBaseballNumbers(baseballInput);
        checkLength(baseballInput, BASEBALL_INPUT_LENGTH);
        checkDuplicateNumbers(baseballInput);
    }

    public static void checkProgressInput(String progressInput) {
        if (!progressInput.equals(RESTART) && !progressInput.equals(EXIT)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkLength(String input, Integer length) {
        if (input.length() != length) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkBaseballNumbers(String input) {
        for (char ch : input.toCharArray()) {
            checkDigit(ch);
            checkBaseballNumberRange(Character.getNumericValue(ch));
        }
    }

    private static void checkDigit(char ch) {
        if (!Character.isDigit(ch)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkBaseballNumberRange(Integer number) {
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplicateNumbers(String input) {
        Set<String> duplicateNumbers = new HashSet<>(List.of(input.split("")));
        if (duplicateNumbers.size() != BASEBALL_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
