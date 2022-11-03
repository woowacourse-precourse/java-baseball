package baseball;

public class Ball {

    public static final String BALL_NUMBER_EX_MESSAGE = "볼의 숫자는 1~9까지만 가능합니다.";
    public static final int MINIMUM_BALL_NUMBER = 1;
    public static final int MAXIMUM_BALL_NUMBER = 9;

    private final int index;
    private final int number;

    public Ball(int index, int number) {
        validate(number);
        this.index = index;
        this.number = number;
    }

    private void validate(int number) {
        if (number < MINIMUM_BALL_NUMBER || number > MAXIMUM_BALL_NUMBER) {
            throw new IllegalArgumentException(BALL_NUMBER_EX_MESSAGE);
        }
    }

    public boolean isStrike(Ball otherBall) {
        return isSameIndex(otherBall) && isSameNumber(otherBall);
    }

    public boolean isBall(Ball otherBall) {
        return !isSameIndex(otherBall) && isSameNumber(otherBall);
    }

    public boolean isNothing(Ball otherBall) {
        return !isSameIndex(otherBall) && !isSameNumber(otherBall);
    }

    private boolean isSameIndex(Ball otherBall) {
        return this.index == otherBall.index;
    }

    private boolean isSameNumber(Ball otherBall) {
        return this.number == otherBall.number;
    }
}
