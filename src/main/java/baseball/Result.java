package baseball;

import java.util.HashSet;
import java.util.List;

import static baseball.Const.SIZE;

public class Result {
    private Integer strike;
    private Integer ball;
    private HashSet<Integer> indexOfStrike;

    public Result() {
        this.strike = 0;
        this.ball = 0;
        indexOfStrike = new HashSet<>();
    }

    public void getCompareResult(Balls problem, Balls input) {
        List<Ball> problemBallList = problem.getBallList();
        List<Ball> inputBallList = input.getBallList();
        calculateStrike(problemBallList, inputBallList);
        calculateBall(problemBallList, inputBallList);
    }

    public void calculateStrike(List<Ball> problemBallList, List<Ball> inputBallList) {
        for (int i = 0; i < SIZE; i++) {
            Integer problemBall = problemBallList.get(i).getNumber();
            Integer inputBall = inputBallList.get(i).getNumber();

            if (problemBall == inputBall) { // 스트라이크
                this.strike += 1;
                indexOfStrike.add(i);
            }
        }
    }

    public void calculateBall(List<Ball> problemBallList, List<Ball> inputBallList) {
        for (int i = 0; i < SIZE; i++) {
            if (!indexOfStrike.contains(i)) { // 스트라이크 자리가 아닐 때
                determiningIfIsBall(problemBallList, inputBallList.get(i));
            }
        }
    }

    public void determiningIfIsBall(List<Ball> problemBallList, Ball ball) {
        if (problemBallList.contains(ball)) {
            this.ball += 1;
        }
    }

    public void clear() {
        this.strike = 0;
        this.ball = 0;
        this.indexOfStrike.clear();
    }

    public Integer getStrike() {
        return this.strike;
    }

    public Integer getBall() {
        return this.ball;
    }
}
