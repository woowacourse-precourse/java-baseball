package baseball.domain;

import java.util.List;

import static baseball.vo.ValidationMsg.NUMBER_RANGE_EXCEPTION;

public class Player {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final List<Integer> playerNumbers;

    public Player(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
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
