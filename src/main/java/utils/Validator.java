package utils;

import java.util.*;

public class Validator {
    private static String input;

    public static void validate(String inputNumber) {
        input = inputNumber;
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
}
