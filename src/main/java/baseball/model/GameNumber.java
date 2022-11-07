package baseball.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameNumber {
    private static final int NUMBERS_SIZE = 3;
    private static final int START_NUM = 1;
    private static final int END_NUM = 9;

    private final List<Integer> numbers;

    public GameNumber(List<Integer> numbers) {
        checkValidSize(numbers);
        checkValidRange(numbers);
        checkDuplicated(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static GameNumber from(String input) {
        try {
            return new GameNumber(convertToList(input));
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> convertToList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void checkDuplicated(List<Integer> numbers) {
        Set<Integer> DeduplicationNumbers = new HashSet<>(numbers);

        if (DeduplicationNumbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("Invalid Input Numbers");
        }
    }

    private void checkValidSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("Invalid Input Numbers");
        }
    }

    private void checkValidRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START_NUM || number > END_NUM) {
                throw new IllegalArgumentException("Invalid Input Numbers");
            }
        }
    }
}
