package baseball.ball;

import java.util.List;

public class Balls {
    private static final int BALL_SIZE = 3;
    private List<Ball> balls;

    public Balls() {
    }

    public boolean validateBallsSize() {
        return balls.size() == BALL_SIZE;
    }

    public boolean hasBall(Ball ball) {
        return balls.stream()
                .anyMatch(x -> x.getBallNumber() == ball.getBallNumber());
    }

    public void containBalls(Ball ball) {
        balls.add(ball);
    }
}