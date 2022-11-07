package baseball.ball;

public final class Ball {
    private final int MINIMUM_NUM_RANGE = 1;
    private final int MAXIMUM_NUM_RANGE = 9;
    private final int MINIMUM_INDEX_RANGE = 0;
    private final int MAXIMUM_INDEX_RANGE = 2;
    private final int number;
    private final int index;

    public Ball(int number, int index) {
        validateNumRange(number);
        validateIndexRange(index);

        this.number = number;
        this.index = index;
    }

    public int getNumber() {
        return number;
    }

    public int getIndex() {
        return index;
    }

    private void validateNumRange(int num) {
        if (num < MINIMUM_NUM_RANGE || MAXIMUM_NUM_RANGE < num) {
            throw new IllegalArgumentException("Ball의 number 범위를 벗어났습니다. num: " + num);
        }
    }

    private void validateIndexRange(int index) {
        if (index < MINIMUM_INDEX_RANGE || MAXIMUM_INDEX_RANGE < index) {
            throw new IllegalArgumentException("Ball의 index 범위가 벗어났습니다. index: " + index);
        }
    }

    public BallResult compare(Ball otherBall) {
        if (isNumAndIndexEqual(otherBall)) {
            return BallResult.STRIKE;
        }
        if (isNumEqualAndIndexDifferent(otherBall)) {
            return BallResult.BALL;
        }
        return BallResult.NOTHING;
    }

    private boolean isNumEqualAndIndexDifferent(Ball otherBall) {
        return number == otherBall.getNumber();
    }

    private boolean isNumAndIndexEqual(Ball otherBall) {
        return number == otherBall.getNumber() && index == otherBall.getIndex();
    }
}
