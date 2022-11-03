package baseball;

public class Ball {

    private final int index;
    private final int number;

    public Ball(int index, int number) {
        this.index = index;
        this.number = number;
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
