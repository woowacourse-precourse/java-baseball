package baseball;

public class Ball {
    private final int position;
    private final int ballNum;

    public Ball(int position, int ballNum) {
        this.position = position;
        this.ballNum = ballNum;
    }

    public BallStatus play(Ball ball) {
        if (isBallNumMatch(ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isBallNumMatch(Ball ball) {
        return this.ballNum == ball.ballNum;
    }
}
