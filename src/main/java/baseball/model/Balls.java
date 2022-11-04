package baseball.model;

import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public boolean isStrike(Ball other) {
        for (Ball ball : balls) {
            if (ball.isStrike(other)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBall(Ball other) {
        for (Ball ball : balls) {
            if (ball.isBall(other)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOut(Ball other) {
        for (Ball ball : balls) {
            if (!ball.isOut(other)) {
                return false;
            }
        }
        return true;
    }
}
