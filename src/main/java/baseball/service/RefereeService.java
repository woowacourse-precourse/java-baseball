package baseball.service;

import baseball.Ball;
import baseball.Result;

import java.util.List;

public class RefereeService {
    public Result generateResult(List<Ball> computerBalls, List<Ball> playerBalls) {
        Result result = new Result();
        for (int i = 0; i < playerBalls.size(); i++) {
            Ball computerBall = computerBalls.get(i);
            Ball playerBall = playerBalls.get(i);

            if (computerBall.equals(playerBall)) {
                result.increaseStrikeCount();
                continue;
            }
            if (computerBalls.contains(playerBall)) {
                result.increaseBallCount();
            }
        }
        return result;
    }
}
