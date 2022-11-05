package baseball.ball;

public class Ball {
    private final int MINIMUM_NUM_RANGE = 1;
    private final int MAXIMUM_NUM_RANGE = 9;
    private final int MINIMUM_INDEX_RANGE = 0;
    private final int MAXIMUM_INDEX_RANGE = 2;
    private final int num;
    private final int index;

    public int getNum() {
        return num;
    }

    public int getIndex() {
        return index;
    }

    public Ball(int num, int index) {
        validateNumRange(num);
        validateIndexRange(index);

        this.num = num;
        this.index = index;
    }

    private void validateNumRange(int num) {
        if (num < MINIMUM_NUM_RANGE || MAXIMUM_NUM_RANGE < num) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIndexRange(int index) {
        if (index < MINIMUM_INDEX_RANGE || MAXIMUM_INDEX_RANGE < index) {
            throw new IllegalArgumentException();
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
        return num == otherBall.getNum();
    }

    private boolean isNumAndIndexEqual(Ball otherBall) {
        return num == otherBall.getNum() && index == otherBall.getIndex();
    }
}
