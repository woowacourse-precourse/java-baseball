package baseball.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Balls {
    public static final int NUMBER_OF_BALLS = 3;
    public static final String ERR_DUPLICATE_INPUT = "중복 되지 않는 수를 입력해주세요.";
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
        validateBalls();
    }

    private void validateBalls() {
        Set<Integer> numbers = balls.stream()
                .map(Ball::getNumber)
                .collect(Collectors.toSet());

        if (numbers.size() != NUMBER_OF_BALLS)
            throw new IllegalArgumentException(ERR_DUPLICATE_INPUT);
    }

    public boolean isBall(Ball other) {
        return balls.stream()
                .anyMatch(ball -> ball.isBall(other));
    }

    public boolean isStrike(Ball other) {
        return balls.stream()
                .anyMatch(ball -> ball.isStrike(other));
    }

    public boolean isOut(Ball ball) {
        return !isBall(ball) && !isStrike(ball);
    }

    public Result getResult(Balls other) {
        Result result = new Result(0, 0, 0);

        for (Ball otherBall : other.balls) {
            result = judgeBall(otherBall, result);
        }

        return result;
    }

    private Result judgeBall(Ball ball, Result result) {
        if (isBall(ball)) {
            result = result.increaseBallCount();
        }
        if (isStrike(ball)) {
            result = result.increaseStrikeCount();
        }
        if (isOut(ball)) {
            result = result.increaseOutCount();
        }

        return result;
    }
}
