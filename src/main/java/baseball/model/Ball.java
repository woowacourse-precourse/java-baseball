package baseball.model;

import java.util.Objects;

public class Ball {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        validateNumber(number);
        this.position = position;
        this.number = number;
    }

    private void validateNumber(int number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("1~9사이의 숫자만 입력 가능합니다.");
        }
    }

    private boolean isValidNumber(int number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }

    public BallStatus match(Ball ball) {
        if (isStrike(ball)) {
            return BallStatus.STRIKE;
        }
        if (isBall(ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isStrike(Ball ball) {
        return ball.equals(this);
    }

    private boolean isBall(Ball ball) {
        return ball.isSameNumber(this.number);
    }

    private boolean isSameNumber(int number) {
        return number == this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
