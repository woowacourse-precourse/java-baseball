package baseball;

import java.util.HashSet;

public class InputValidator {
    public static final int INPUT_NUMBER_LENGTH_LIMIT = 3;
    public static final char ZERO_CHARACTER = '0';

    public static void validateInputNumber(String numbers) {
        validateOnlyNumbers(numbers);

        validateThreeLength(numbers);

        validateDuplication(numbers);

        validateZeroIncluded(numbers);
    }

    public static void validateOnlyNumbers(String numbers) {
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static void validateThreeLength(String numbers) {
        if (numbers.length() != INPUT_NUMBER_LENGTH_LIMIT) {
            throw new IllegalArgumentException(Message.NOT_THREE_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public static void validateDuplication(String numbers) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < numbers.length(); i++) {
            if (set.contains(numbers.charAt(i))) {
                throw new IllegalArgumentException(Message.DUPLICATE_NUMBER_EXCEPTION_MESSAGE);
            }

            if (!set.contains(numbers.charAt(i))) {
                set.add(numbers.charAt(i));
            }
        }
    }

    public static void validateZeroIncluded(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == ZERO_CHARACTER) {
                throw new IllegalArgumentException(Message.ZERO_INCLUDED_EXCEPTION_MESSAGE);
            }
        }
    }
}
