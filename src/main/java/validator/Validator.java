package utils;

import java.util.*;

public class Validator {
    private static String input;
    private static final int INPUT_LENGTH = 3;
    private static final int INPUT_RANGE_MIN = 1;
    private static final int INPUT_RANGE_MAX = 9;

    public static void validate(String inputNumber) {
        input = inputNumber;
        validateSize();
        validateDuplicateNumber();
        validateInteger();
    }

    private static void validateSize() {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException("3개의 수만 입력 가능합니다.");
        }
    }

    private static void validateDuplicateNumber() {
        List<String> numbers = List.of(input.split(""));
        Set<String> inputSet = new HashSet<>(numbers);
        if (inputSet.size() != input.length()) {
            throw new IllegalArgumentException("서로 다른 수만 입력 가능합니다.");
        }
    }

    private static void validateInteger() {
        String regex = "[^" + INPUT_RANGE_MIN + "-" + INPUT_RANGE_MAX + "]";
        String numbers = input.replaceAll(regex, "");
        if (numbers.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException("1 ~ 9 사이의 숫자만 입력 가능합니다.");
        }
    }

    public static void validateRestartFlag(String restartFlag) {
        if (!(restartFlag.equals("1") || restartFlag.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }
}
