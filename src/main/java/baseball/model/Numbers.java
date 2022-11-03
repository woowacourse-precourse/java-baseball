package baseball.model;

import java.util.List;

public class Numbers {
    private final int index;
    private final int value;

    public Numbers(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public boolean isStrike(List<Integer> gameNumber) {
        return gameNumber.contains(value) && gameNumber.get(index) == value;
    }

    public boolean isBall(List<Integer> gameNumber) {
        return gameNumber.contains(value) && gameNumber.get(index) != value;
    }
}