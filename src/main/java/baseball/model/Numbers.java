package baseball.model;

public class Numbers {
    private final int index;
    private final int value;

    public Numbers(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public boolean isStrike(GameNumber gameNumber) {
        return hasValue(gameNumber) && samePosition(gameNumber);
    }

    public boolean isBall(GameNumber gameNumber) {
        return hasValue(gameNumber) && !samePosition(gameNumber);
    }

    private boolean hasValue(GameNumber gameNumber) {
        return gameNumber.contains(value);
    }

    private boolean samePosition(GameNumber gameNumber) {
        return gameNumber.get(index) == value;
    }
}