package baseball.domain;

import java.util.List;

public class Result {
    private int strike;
    private int ball;

    public static Result getResult(Balls computer, Balls player) {
        Result result = new Result();
        List<Ball> computerBalls = computer.getBalls();
        List<Ball> playerBalls = player.getBalls();
        for (Ball playerBall : playerBalls) {
            result.calculateResult(computerBalls, playerBall);
        }
        return result;
    }

    private void calculateResult(List<Ball> computerBalls, Ball playerBall) {
        for (Ball computerBall : computerBalls) {
            calculateStrike(computerBall, playerBall);
            calculateBall(computerBall, playerBall);
        }
    }

    private void calculateStrike(Ball computerBall, Ball playerBall) {
        if (isStrike(computerBall, playerBall)) {
            this.increaseStrike();
        }
    }

    private boolean isStrike(Ball computerBall, Ball playerBall) {
        return computerBall.number() == playerBall.number()
                && computerBall.position() == playerBall.position();
    }

    private void calculateBall(Ball computerBall, Ball playerBall) {
        if (isBall(computerBall, playerBall)) {
            this.increaseBall();
        }
    }

    private boolean isBall(Ball computerBall, Ball playerBall) {
        return computerBall.number() == playerBall.number()
                && computerBall.position() != playerBall.position();
    }

    public void increaseBall() {
        this.ball++;
    }

    public void increaseStrike() {
        this.strike++;
    }

    public boolean isCorrect() {
        return this.strike == Balls.BALLS_SIZE;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
