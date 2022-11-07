package baseball.baseballgame.ball;

import java.util.Objects;

public class BallNumber {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 9;
    public static final String BALL_NUMBER_ERROR = "볼넘버는 " + MIN_RANGE + "이상" + MAX_RANGE + "이하의 숫자여야 합니다.";
    private final int ballNumber;

    public BallNumber(int number) {
        validateRange(number);
        this.ballNumber = number;
    }

    private void validateRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(BALL_NUMBER_ERROR);
        }
    }


    public static BallNumber createBallNumber(int number) {
        return new BallNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BallNumber)) {
            return false;
        }
        BallNumber that = (BallNumber) o;
        return ballNumber == that.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }
}
