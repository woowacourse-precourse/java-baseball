package baseball.model;

public class InputNumber {
    private final int index;
    private final int value;

    public InputNumber(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public boolean isStrike(BaseNumber baseNumber) {
        return hasValue(baseNumber) && samePosition(baseNumber);
    }

    public boolean isBall(BaseNumber baseNumber) {
        return hasValue(baseNumber) && !samePosition(baseNumber);
    }

    private boolean hasValue(BaseNumber baseNumber) {
        return baseNumber.contains(value);
    }

    private boolean samePosition(BaseNumber baseNumber) {
        return baseNumber.get(index) == value;
    }
}