package baseball.view.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {

    private static final int NUMBER_MAX_RANGE = 3;
    private static final String NUMBER_RANGE = "^[1-9]*$";
    private static final String YES = "1";
    private static final String NO = "2";

    public static void validate(String input) {
        if (!Pattern.matches(NUMBER_RANGE, input)) {
            throw new IllegalArgumentException();
        }
        if (input.length() != NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException();
        }
        String[] numbers = input.split("");
        Set<String> ballNums = new HashSet<>(Arrays.asList(numbers));

        if (ballNums.size() != numbers.length) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateUserChoice(String choice) {
        if (!choice.equals(YES) && !choice.equals(NO)) {
            throw new IllegalArgumentException();
        }
    }
}
