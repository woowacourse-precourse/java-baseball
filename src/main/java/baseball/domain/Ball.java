package baseball.domain;

public class Ball {
    private final BallIndex ballIndex;
    private final BallNumber ballNumber;

    public Ball(int index, int ballNumber) {
        this.ballIndex = new BallIndex(index);
        this.ballNumber = new BallNumber(ballNumber);
    }

    public BallStatus compareTo(Ball compareBall) {
        if (this.equals(compareBall)) {
            return BallStatus.STRIKE;
        }
        if (this.ballNumber.equals(compareBall.ballNumber)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballIndex.equals(ball.ballIndex) && ballNumber.equals(ball.ballNumber);
    }
}
