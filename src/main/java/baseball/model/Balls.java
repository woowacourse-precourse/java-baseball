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

    public Result getResult(Balls other) {
        int ball = 0, strike = 0, out = 0;

        for (Ball otherBall : other.balls) {
            switch (judgeball(otherBall)) {
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

    private Judgement judgeball(Ball ball) {
        if (isBall(ball)) {
            return Judgement.BALL;
        }
        if (isStrike(ball)) {
            return Judgement.STRIKE;
        }
        if (isOut(ball)) {
            return Judgement.OUT;
        }

        return null;
    }
}
