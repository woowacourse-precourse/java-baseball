package baseball.domain;

import java.util.Objects;

public class Ball {

    private final int position;
    private final int number;

    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }
    public static Ball of(int number, int position){
        return new Ball(number,position);
    }

    public BallType play(Ball computerBall) {
        if (this.equals(computerBall)) {
            return BallType.STRIKE;
        }
        if (this.number == computerBall.number) {
            return BallType.BALL;
        }
        return BallType.NOTHING;
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
