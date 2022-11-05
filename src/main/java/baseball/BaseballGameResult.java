package baseball;

import java.util.List;

public class BaseballGameResult {

    private final int strike;
    private final int ball;

    int calcStrikes(List<Integer> answerNums, List<Integer> inputNums) {
        int strike = 0;
        for (int idx = 0; idx < 3; idx++) {
            if (answerNums.get(idx).equals(inputNums.get(idx))) {
                strike++;
            }
        }
        return strike;
    }
}
