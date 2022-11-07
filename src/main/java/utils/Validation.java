package utils;

import static baseball.type.NumberType.NUMBER_SIZE;

import java.util.HashSet;

public class Validation {
    public static void validate(String inputNumber) {
        validateNumber(inputNumber);
        validateDuplication(inputNumber);
        validateSize(inputNumber);
        validateNotZero(inputNumber);
    }

    private static void validateNumber(String inputNumber) {
        if (!(inputNumber.matches("[+-]?\\d*(\\.\\d+)?"))) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplication(String inputNumber) {
        HashSet<Character> numbers = new HashSet<>();

        for (char number : inputNumber.toCharArray()) {
            numbers.add(number);
        }

        if (numbers.size() != NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSize(String inputNumber) {
        int numberSize = inputNumber.length();

        if (numberSize != NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNotZero(String inputNumber) {
        if (inputNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
    }
}
