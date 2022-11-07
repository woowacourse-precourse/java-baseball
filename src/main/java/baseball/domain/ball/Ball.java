package baseball.domain.ball;

import java.util.Objects;

public class Ball {

    private static final int BALL_MIN_RANGE = 1;
    private static final int BALL_MAX_RANGE = 9;
    private final int position;
    private final int number;

    private Ball(int number, int position) {
        validate(number);
        this.number = number;
        this.position = position;
    }

    public static Ball of(int number, int position) {
        return new Ball(number, position);
    }

    private void validate(int number) {
        if ( BALL_MIN_RANGE > number || number > BALL_MAX_RANGE){
            throw new IllegalArgumentException();
        }
    }

    public BallType play(Ball ball) {
        if (this.equals(ball)) {
            return BallType.STRIKE;
        }
        if (isBall(ball)) {
            return BallType.BALL;
        }
        return BallType.NOTHING;
    }

    private boolean isBall(Ball ball) {
        return this.number == ball.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
