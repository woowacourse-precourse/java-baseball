package baseball;

import java.util.List;

public class NumberComparator {

    private final List<Integer> inputNumbers;
    private final List<Integer> resultNumbers;

    private int strike;
    private int ball;

    public NumberComparator(List<Integer> inputNumbers, List<Integer> resultNumbers) {
        this.inputNumbers = inputNumbers;
        this.resultNumbers = resultNumbers;
        strike = 0;
        ball = 0;
    }

    public void compare() {
        int COMPARE_LENGTH = 3;
        for (int i = 0; i < COMPARE_LENGTH; i++) {
            if (isStrike(i)) {
                strike++;
                continue;
            }
            if (isBall(i)) {
                ball++;
            }
        }
    }

    public boolean isStrike(int index) {
        return inputNumbers.get(index) == resultNumbers.get(index);
    }

    public boolean isBall(int index) {
        return resultNumbers.contains(inputNumbers.get(index));
    }

    public String getCompareResult() {
        if (strike == 0 && ball == 0)
            return "낫싱";
        if (ball == 0)
            return strike + "스트라이크";
        if (strike == 0)
            return ball + "볼";
        return ball + "볼" + " " + strike + "스트라이크";
    }

}
