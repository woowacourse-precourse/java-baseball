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

    public boolean isStrike(Ball other) {
        return balls.stream()
                .anyMatch(ball -> ball.isStrike(other));
    }

    public boolean isBall(Ball other) {
        return balls.stream()
                .anyMatch(ball -> ball.isBall(other));
    }

    public Result getResult(Balls other) {
        int ball = 0, strike = 0, out = 0;

        for (Ball otherBall : other.balls) {
            switch (judgeBall(otherBall)) {
                case BALL:
                    ball += 1; break;
                case STRIKE:
                    strike += 1; break;
                case OUT:
                    out += 1; break;
            }
        }

        return new Result(ball, strike, out);
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
