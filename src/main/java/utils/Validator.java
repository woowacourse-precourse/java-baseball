package utils;

import java.util.*;

public class Validator {
    private static String input;

    public static void validate(String inputNumber) {
        input = inputNumber;
        validateSize();
        validateDuplicateNumber();
        validateInteger();
    }

    private static void validateSize() {
        if (input.length() != 3) {
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
        String numbers = input.replaceAll("[^1-9]", "");
        if (numbers.length() != 3) {
            throw new IllegalArgumentException("1 ~ 9 사이의 숫자만 입력 가능합니다.");
        }
    }

    public static void validateRestartFlag(String restartFlag) {
        if (!(restartFlag.equals("1") || restartFlag.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }
}
