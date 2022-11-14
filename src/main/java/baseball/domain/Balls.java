package baseball.domain;

import java.util.List;

public class Balls {

    private final List<Integer> balls;

    public Balls(List<Integer> balls) {
        this.balls = balls;
    }

    public Result makeResult(Balls playerBalls) {
        Result result = new Result();

        for (int i = 0; i < balls.size(); i++) {
            int ball = balls.get(i);
            playerBalls.judge(ball, i, result);
        }

        return result;
    }

    private void judge(int ball, int index, Result result) {
        int ballIndex = balls.indexOf(ball);

        if (ballIndex == -1) {
            return;
        }

        if (ballIndex == index) {
            result.addStrikeCount();
            return;
        }

        result.addBallCount();
    }
}
