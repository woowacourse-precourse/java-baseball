package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> ballNums) {
        this.balls = mapIntToBall(ballNums);
    }

    private List<Ball> mapIntToBall(List<Integer> ballNums) {
        List<Ball> result = new ArrayList<>();
        for (int i = 0; i < ballNums.size(); i++) {
            result.add(new Ball(i, ballNums.get(i)));
        }
        return result;
    }

    public BallStatus play(Ball ball) {
        return balls.stream().map(m -> m.play(ball))
                .filter(status -> status != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public Result play(List<Integer> ballNums) {
        Balls userBalls = new Balls(ballNums);
        Result result = new Result();

        for (Ball ball : balls) {
            BallStatus status = userBalls.play(ball);
            result.report(status);
        }

        return result;
    }
}

