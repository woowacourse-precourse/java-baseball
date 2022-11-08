package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.vo.ValidationMsg.*;

public class Player {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBERS_COUNT = 3;

    private final List<Integer> playerNumbers;

    public Player(List<Integer> playerNumbers) {
        validate(playerNumbers);
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    private void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }

        if (validateNumbersSize(numbers)) {
            throw new IllegalArgumentException(NUMBERS_SIZE_EXCEPTION.getMessage());
        }

        if (validateDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    private boolean validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbers.size() != numbersSet.size();
    }

    private boolean validateNumbersSize(List<Integer> numbers) {
        return numbers.size() != NUMBERS_COUNT;
    }

    private void validateNumberRange(int number) {
        if (validateIsLessThanMinNumber(number) || validateIsMoreThanMaxNumber(number)) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    private boolean validateIsLessThanMinNumber(int number) {
        return number < MIN_NUMBER;
    }

    private boolean validateIsMoreThanMaxNumber(int number) {
        return number > MAX_NUMBER;
    }
}
