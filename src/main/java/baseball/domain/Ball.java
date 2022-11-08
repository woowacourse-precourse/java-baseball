package baseball.domain;

import java.util.Objects;

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
    
    public BallStatus compareOneBall(final Ball userBall) {
        if (isStrike(userBall)) {
            return BallStatus.STRIKE;
        }
        
        if (isSameNumber(userBall)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }
    
    private boolean isStrike(final Ball userBall) {
        return this.equals(userBall);
    }
    
    public boolean isSameNumber(final Ball otherBall) {
        return this.ballNumber.equals(otherBall.ballNumber);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ball ball = (Ball) o;
        return Objects.equals(ballPosition, ball.ballPosition) && Objects.equals(ballNumber, ball.ballNumber);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(ballPosition, ballNumber);
    }
    
    @Override
    public String toString() {
        return "Ball{" +
                "ballPosition=" + ballPosition +
                ", ballNumber=" + ballNumber +
                '}';
    }
}
