package baseball;

import java.util.List;

public class Result {

    private int strike;

    public boolean countResult(List<Integer> baseball, List<Integer> input) {

        countStrike(baseball, input);

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

    public int getStrike() {
        return strike;
    }
}
