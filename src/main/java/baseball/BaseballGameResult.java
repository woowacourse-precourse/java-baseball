package baseball;

import java.util.List;

public class BaseballGameResult {

    private final int strike;
    private final int ball;

    BaseballGameResult(List<Integer> answerNums, List<Integer> inputNums) {
        this.strike = calcStrikes(answerNums, inputNums);
        this.ball = calcBalls(answerNums, inputNums);
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
}
