package baseball.model;

import java.util.List;

public class Result {
    private int strike = 0;
    private int ball = 0;

    public static Result getResult(Answer targetAnswer, Answer inputAnswer) {
        Result result = new Result();
        List<Ball> targetBalls = targetAnswer.getBalls();
        List<Ball> inputBalls = inputAnswer.getBalls();

        for (Ball inputBall : inputBalls) {
            result.calculateResult(targetBalls, inputBall);
        }

        return result;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void increaseStrike() {
        this.strike++;
    }

    public void increaseBall() {
        this.ball++;
    }

    private void calculateResult(List<Ball> answerBalls, Ball inputBall) {
        for (Ball answerBall : answerBalls) {
            calculateStrike(answerBall, inputBall);
            calculateBall(answerBall, inputBall);
        }
    }

    private void calculateStrike(Ball answerBall, Ball inputBall) {
        if (isStrike(answerBall, inputBall)) {
            this.increaseStrike();
        }
    }

    private void calculateBall(Ball answerBall, Ball inputBall) {

        if (isBall(answerBall, inputBall)) {
            this.increaseBall();
        }
    }

    private boolean isStrike(Ball answerBall, Ball inputBall) {
        return answerBall.number() == inputBall.number()
                && answerBall.position() == inputBall.position();
    }

    private boolean isBall(Ball answerBall, Ball inputBall) {
        return answerBall.number() == inputBall.number() &&
                answerBall.position() != inputBall.position();
    }

    public boolean isCorrectAnswer() {
        return strike == Answer.ANSWER_SIZE;
    }
}
