package baseball;

import java.util.List;

public class Result {

    private int strike;

    private int ball;

    public boolean countResult(List<Integer> baseball, List<Integer> input) {
        countStrike(baseball, input);
        countBall(baseball, input);

        return false;
    }

    public void countStrike(List<Integer> baseball, List<Integer> input) {
        strike = 0;
        for (int i=0; i<baseball.size(); i++) {
            if (baseball.get(i).equals(input.get(i))) {
              strike++;
            }
        }
    }

    public void countBall(List<Integer> baseball, List<Integer> input) {
        ball = 0;
        for (int i=0; i<baseball.size(); i++) {
            if (checkEqualNum(baseball.get(i), i, input)) {
                ball++;
            }
        }
    }

    public boolean checkEqualNum(Integer baseballNum, int index, List<Integer> input) {
        for (int i=0; i<input.size(); i++) {
            if (input.get(i) == baseballNum && i != index) {
                return true;
            }
        }
        return false;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
