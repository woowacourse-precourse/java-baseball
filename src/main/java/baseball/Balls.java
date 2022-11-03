package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    public static final int BALL_CNT = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> ballNums) {
        List<Ball> result = new ArrayList<>();
        mapInt2Ball(ballNums, result);
        this.balls = result;
    }

    private void mapInt2Ball(List<Integer> ballNums, List<Ball> result) {
        for (int i = 0; i < BALL_CNT; i++) {
            result.add(new Ball(i, ballNums.get(i)));
        }
    }

    public BallStatus play(Ball ball) {
        return balls.stream().map(m -> m.play(ball))
                .filter(status -> status != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
