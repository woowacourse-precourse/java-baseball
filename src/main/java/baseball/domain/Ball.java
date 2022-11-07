package baseball.domain;

public class Ball {

    public static final String BALL_NUMBER_EX_MESSAGE = "볼의 숫자는 1~9까지만 가능합니다.";
    public static final int MINIMUM_BALL_NUMBER = 1;
    public static final int MAXIMUM_BALL_NUMBER = 9;

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        validate(number);
        this.position = position;
        this.number = number;
    }

    private void validate(int number) {
        if (!isCorrectRange(number)) {
            throw new IllegalArgumentException(BALL_NUMBER_EX_MESSAGE);
        }
    }

    private boolean isCorrectRange(int number) {
        return (number >= MINIMUM_BALL_NUMBER) && (number <= MAXIMUM_BALL_NUMBER);
    }

    public BallMatchResult match(Ball otherBall) {
        if (this.isStrike(otherBall)) {
            return BallMatchResult.STRIKE;
        }
        if (this.isBall(otherBall)) {
            return BallMatchResult.BALL;
        }
        return BallMatchResult.NOTHING;
    }

    private boolean isStrike(Ball otherBall) {
        return isSamePosition(otherBall) && isSameNumber(otherBall);
    }

    private boolean isBall(Ball otherBall) {
        return !isSamePosition(otherBall) && isSameNumber(otherBall);
    }

    private boolean isSamePosition(Ball otherBall) {
        return this.position == otherBall.position;
    }

    private boolean isSameNumber(Ball otherBall) {
        return this.number == otherBall.number;
    }

}
