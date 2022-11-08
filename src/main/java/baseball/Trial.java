package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Trial {
    private static final int NUMBERS_SIZE = 3;
    private static final int STRIKE_SCORE = 10;
    private static final int BALL_SCORE = 1;
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다.";

    public static List<Integer> inputNumbers() {
        System.out.print(INPUT_MESSAGE);

        String numbersInput = Console.readLine();

        if (!isValidInput(numbersInput)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        return Arrays.stream(numbersInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getScore(Map<Integer, Integer> numbersMap, List<Integer> inputNumbers) {
        int score = 0;

        for (int index = 0; index < NUMBERS_SIZE; index++) {
            int number = inputNumbers.get(index);

            if (!numbersMap.containsKey(number)) {
                continue;
            }

            if (index == numbersMap.get(number)) {
                score += STRIKE_SCORE;
                continue;
            }

            score += BALL_SCORE;
        }

        return score;
    }

    public static int inputRestartOption() {
        String option = Console.readLine();

        if (!isValidOption(option)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        return Integer.parseInt(option);
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

    private static boolean isValidOption(String option) {
        return option.equals("1") || option.equals("2");
    }
}
