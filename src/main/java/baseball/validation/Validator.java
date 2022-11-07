package baseball.validation;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;
    private static final int COUNT_VALUE = 3;

    public static void validatePlayerInput(String input) {
        validateInputLength(input);
    }

    public static void validateInputLength(String input) {
        if (input.length() != COUNT_VALUE) {
            throw new IllegalArgumentException("[IllegalArgumentException]: " + COUNT_VALUE + "자리 자리자연수가 아닙니다.\n");
        }
    }

}
