package baseball;

public class Ball {

    private final int index;
    private final int number;

    public Ball(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public boolean isStrike(Ball otherBall) {
        return this.index == otherBall.index
                && this.number == otherBall.number;
    }

    public boolean isBall(Ball otherBall) {
        return this.index != otherBall.index
                && this.number == otherBall.number;
    }

    public boolean isNothing(Ball otherBall) {
        return this.index != otherBall.index
                && this.number != otherBall.number;
    }
}
