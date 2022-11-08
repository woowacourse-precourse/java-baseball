package baseball.ball;

public class Ball {
    private int ballNumber;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String NOT_ALLOWED_UNDER_MIN_NUMBER = "볼은 최소 1 입니다.";
    private static final String NOT_ALLOWED_OVER_MAX_NUMBER = "볼은 최대 9 입니다.";

    public Ball(int ballNumber) {
        validateRange(ballNumber);
        this.ballNumber = ballNumber;
    }

    private void validateRange(int ballNumber) {
        if (ballNumber < MIN_NUMBER) {
            throw new IllegalArgumentException(NOT_ALLOWED_UNDER_MIN_NUMBER);
        }
        if (ballNumber > MAX_NUMBER) {
            throw new IllegalArgumentException((NOT_ALLOWED_OVER_MAX_NUMBER);
        }
    }

    public int getBallNumber() {
        return ballNumber;
    }
}