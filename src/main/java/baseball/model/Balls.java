package baseball.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Balls {
    public static final int NUMBER_OF_BALLS = 3;
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
            throw new IllegalArgumentException();
    }

    public boolean isBall(Ball other) {
        return balls.stream()
                .anyMatch(ball -> ball.isBall(other));
    }

    public boolean isStrike(Ball other) {
        return balls.stream()
                .anyMatch(ball -> ball.isStrike(other));
    }

    private boolean isOut(Ball ball) {
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

    public Judgement judgeBall(Ball ball) {
        if (isBall(ball)) {
            return Judgement.BALL;
        }
        if (isStrike(ball)) {
            return Judgement.STRIKE;
        }

        return Judgement.OUT;
    }
}
