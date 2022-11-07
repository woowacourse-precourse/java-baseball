package baseball;

import java.util.List;

public class NumberComparator {

    private final List<Integer> inputNumberList;
    private final List<Integer> resultNumberList;

    private int strike;
    private int ball;

    public NumberComparator(List<Integer> inputNumberList, List<Integer> resultNumberList) {
        this.inputNumberList = inputNumberList;
        this.resultNumberList = resultNumberList;
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
        return inputNumberList.get(index) == resultNumberList.get(index);
    }

    public boolean isBall(int index) {
        return resultNumberList.contains(inputNumberList.get(index));
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
