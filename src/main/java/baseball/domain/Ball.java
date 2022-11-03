package baseball.domain;

public class Ball {
    private final BallPosition ballPosition;
    private final BallNumber ballNumber;
    
    public Ball(final int position, final String number) {
        this(new BallPosition(position), new BallNumber(number));
    }
    
    public Ball(final int position, final int number) {
        this(new BallPosition(position), new BallNumber(number));
    }
    
    public Ball(final BallPosition ballPosition, final BallNumber ballNumber) {
        this.ballPosition = ballPosition;
        this.ballNumber = ballNumber;
    }
    
    public BallStatus compareOneBall(final Ball ball) {
        return BallStatus.STRIKE;
    }
}
