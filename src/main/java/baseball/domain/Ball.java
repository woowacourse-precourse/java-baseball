package baseball.domain;

public class Ball {
    private final int index;
    private final int ballNumber;

    public Ball(int index, int ballNumber) {
        this.index = index;
        this.ballNumber = ballNumber;
    }

    public BallStatus compareTo(Ball compareBall) {
        if (this.equals(compareBall)) {
            return BallStatus.STRIKE;
        }
        if (this.ballNumber == compareBall.ballNumber) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return index == ball.index && ballNumber == ball.ballNumber;
    }
}
