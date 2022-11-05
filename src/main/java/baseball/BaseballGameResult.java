package baseball;

import java.util.List;

public class BaseballGameResult {

    private final int strike;
    private final int ball;

    BaseballGameResult() {
        this.strike = 0;
        this.ball = 0;
    }

    BaseballGameResult(List<Integer> answerNums, List<Integer> inputNums) {
        this.strike = calcStrikes(answerNums, inputNums);
        this.ball = calcBalls(answerNums, inputNums);
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return "낫싱";
        }

        String strikeMessage = "";
        String ballMessage = "";

        if (this.strike != 0) {
            strikeMessage = String.format("%d스트라이크", this.strike);
        }

        if (this.ball != 0) {
            ballMessage = String.format("%d볼", this.ball);
        }

        return String.format("%s %s", ballMessage, strikeMessage);
    }

    public int calcStrikes(List<Integer> answerNums, List<Integer> inputNums) {
        int strike = 0;
        for (int idx = 0; idx < 3; idx++) {
            if (answerNums.get(idx).equals(inputNums.get(idx))) {
                strike++;
            }
        }
        return strike;
    }

    public int calcBalls(List<Integer> answerNums, List<Integer> inputNums) {
        int balls = 0;
        for (int idx = 0; idx < 3; idx++) {
            if (!answerNums.get(idx).equals(inputNums.get(idx)) && answerNums.contains(inputNums.get(idx))) {
                balls++;
            }
        }
        return balls;
    }

    public int numOfStrikes() {
        return this.strike;
    }

    public int numOfBalls() {
        return this.ball;
    }

    public Boolean isNothing() {
        if (strike == 0 && ball == 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
