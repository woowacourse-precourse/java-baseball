package baseball.model.ball;

import java.util.Objects;

public class Ball {
    private final BallNumber ballNumber;

    public Ball(BallNumber ballNumber) {
        this.ballNumber = ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }
        Ball ball = (Ball) o;
        return ballNumber.equals(ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }
}
