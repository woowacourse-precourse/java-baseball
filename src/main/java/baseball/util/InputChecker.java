package baseball.util;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public final class InputChecker {

    private static final int LIMITED_INPUT_SIZE = 3;


    private InputChecker() {
    }

    public static void isValid(String input) {
        isSizeEqualToLimitedSize(input);
        isNotExistRepeatedNumber(input);
    }

    private static void isNotExistRepeatedNumber(String input) {
        String compactInput = Arrays.stream(input.split(""))
                .filter(InputChecker::isDigit)
                .distinct()
                .collect(joining());
        isSizeEqualToLimitedSize(compactInput);
    }

    private static void isSizeEqualToLimitedSize(String input) {
        if (input.length() != LIMITED_INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDigit(String init) {
        if (Character.isDigit(init.charAt(0))) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
