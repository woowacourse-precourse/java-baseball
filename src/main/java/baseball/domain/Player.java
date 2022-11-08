package baseball.domain;

import java.util.List;

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

    private boolean validateIsLessThanMinNumber(int number) {
        return number < MIN_NUMBER;
    }

    private boolean validateIsMoreThanMaxNumber(int number) {
        return number > MAX_NUMBER;
    }
}
