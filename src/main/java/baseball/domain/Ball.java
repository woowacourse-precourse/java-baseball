package baseball.domain;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int ballNum;

    public Ball(int position, int ballNum) {
        this.position = position;
        this.ballNum = ballNum;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (isBallNumMatch(ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public boolean isBallNumMatch(Ball ball) {
        return this.ballNum == ball.ballNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNum == ball.ballNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNum);
    }
}
