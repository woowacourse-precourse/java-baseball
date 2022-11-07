package baseball.ball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private static final int BALL_SIZE = 3;
    private List<Ball> balls;

    public Balls() {
        balls=new ArrayList<>();
    }

    public boolean validateBallsSize() {
        return balls.size() == BALL_SIZE;
    }

    public boolean hasBall(Ball ball) {
        return balls.stream()
                .anyMatch(x -> x.getBallNumber() == ball.getBallNumber());
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }
}