package baseball;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Const.BALL;
import static baseball.Const.SIZE;
import static baseball.Const.STRIKE;

public class Result {
    private int strike;
    private int ball;
    private Set<Integer> indexOfStrike;

    public Result() {
        this.strike = 0;
        this.ball = 0;
        this.indexOfStrike = new HashSet<>();
    }

    public void getCompareResult(CollectionBalls problem, CollectionBalls input) {
        List<Ball> problemBallList = problem.getBallList();
        List<Ball> inputBallList = input.getBallList();
        calculateStrike(problemBallList, inputBallList);
        calculateBall(problemBallList, inputBallList);
    }

    private void calculateStrike(final List<Ball> problemBallList, final List<Ball> inputBallList) { // final
        for (int i = 0; i < SIZE; i++) {
            int problemBall = problemBallList.get(i).getNumber();
            int inputBall = inputBallList.get(i).getNumber();

            if (problemBall == inputBall) { // 스트라이크
                this.strike++;
                indexOfStrike.add(i);
            }
        }
    }

    private void calculateBall(final List<Ball> problemBallList, final List<Ball> inputBallList) {
        for (int i = 0; i < SIZE; i++) {
            if (!indexOfStrike.contains(i)) { // 스트라이크 자리가 아닐 때
                determineIfIsBall(problemBallList, inputBallList.get(i));
            }
        }
    }

    private void determineIfIsBall(final List<Ball> problemBallList, final Ball ball) {
        if (problemBallList.contains(ball)) {
            this.ball++;
        }
    }

    public void clear() {
        this.strike = 0;
        this.ball = 0;
        this.indexOfStrike.clear();
    }

    private String getOutputStatementOfBall() {
        if (this.ball != 0) {
            return (this.ball + BALL);
        }

        return "";
    }

    private String getOutputStatementOfStrike() {
        if (this.strike != 0) {
            return (this.strike + STRIKE);
        }

        return "";
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    @Override
    public String toString() {
        return getOutputStatementOfBall() + getOutputStatementOfStrike();
    }
}
