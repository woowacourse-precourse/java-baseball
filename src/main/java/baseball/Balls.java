package baseball;

import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public BallStatus play(Ball ball) {
        return BallStatus.NOTHING;
    }
}
