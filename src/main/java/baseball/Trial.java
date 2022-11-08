package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Trial {
    private static final int NUMBERS_SIZE = 3;
    private static final String INVALID_INPUT = "잘못된 입력입니다.";
    private static List<Integer> numbers;

    public static void input() {
        String numbersInput = Console.readLine();

        if (!isValidInput(numbersInput)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }

        numbers = Arrays.stream(numbersInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean isValidInput(String numbersInput) {
        return isValidLength(numbersInput) && !isDuplicated(numbersInput)
                && isValidRange(numbersInput);
    }

    private static boolean isValidLength(String numbersInput) {
        return numbersInput.length() == NUMBERS_SIZE;
    }

    private static boolean isValidRange(String numbersInput) {
        return numbersInput.chars()
                .noneMatch(number -> number < '1' || number > '9');
    }

    private static boolean isDuplicated(String numbersInput) {
        return numbersInput.chars()
                .distinct()
                .count() != NUMBERS_SIZE;
    }
}
