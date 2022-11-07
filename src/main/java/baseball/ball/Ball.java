package baseball.ball;

public final class Ball {
    private final Number number;
    private final Index index;

    public Ball(int number, int index) {
        this.number = new Number(number);
        this.index = new Index(index);
    }

    public Number getNumber() {
        return number;
    }

    public Index getIndex() {
        return index;
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
        return number.equals(otherBall.getNumber());
    }

    private boolean isNumAndIndexEqual(Ball otherBall) {
        return number.equals(otherBall.getNumber()) && index.equals(otherBall.getIndex());
    }
}
