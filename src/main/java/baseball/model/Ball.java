package baseball.model;

public class Ball {
    private BallNumber ballNumber;
    private BallPosition ballPosition;

    public Ball(BallPosition ballPosition, BallNumber ballNumber) {
        this.ballPosition = ballPosition;
        this.ballNumber = ballNumber;
    }

    public static Ball of(BallPosition ballPosition, BallNumber ballNumber) {
        return new Ball(ballPosition, ballNumber);
    }

    public int number() {
        return ballNumber.value();
    }

    public int position() {
        return ballPosition.value();
    }
}
