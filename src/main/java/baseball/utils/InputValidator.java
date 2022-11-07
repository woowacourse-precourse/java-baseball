package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public final static Integer RESTART = 1;
    public final static Integer EXIT = 2;
    public final static Integer CHECK_PROGRESS_INPUT_LENGTH = 1;
    public final static Integer BASEBALL_INPUT_LENGTH = 3;

    public static void checkBaseballInput(String baseballInput) {
        checkNumbers(baseballInput);
        checkLength(baseballInput, BASEBALL_INPUT_LENGTH);
    }

    public static void checkProgressInput(String progressInput) {
        checkNumbers(progressInput);
        checkLength(progressInput, CHECK_PROGRESS_INPUT_LENGTH);
        checkRightRetryNumber(Integer.parseInt(progressInput));
    }

    private static void checkRightRetryNumber(Integer progressNumber) {
        if (progressNumber.equals(RESTART) && progressNumber.equals(EXIT)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkLength(String input, Integer length) {
        if (input.length() != length) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNumbers(String input) {
        Set<Integer> duplicateNumbers = new HashSet<>();
        for (char ch : input.toCharArray()) {
            checkDigit(ch);
            checkNumberRange(Character.getNumericValue(ch));
            duplicateNumbers.add(Character.getNumericValue(ch));
        }
        checkDuplicateNumbers(duplicateNumbers);
    }

    private static void checkDigit(char ch) {
        if (!Character.isDigit(ch)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNumberRange(Integer number) {
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplicateNumbers(Set<Integer> duplicateNumbers) {
        if (duplicateNumbers.size() != BASEBALL_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
