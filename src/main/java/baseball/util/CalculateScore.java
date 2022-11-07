package baseball.util;

import java.util.List;

public class CalculateScore {
    private static final int NUMBER_COUNT = 3;
    private List<Integer> computerNumberList;

    public CalculateScore() {
    }

    public void setComputerNumber(List<Integer> computerNumberList) {
        this.computerNumberList = computerNumberList;
    }

    public int compareNumber(int number, int order) {
        for (int i = 0; i < NUMBER_COUNT; i++) {
            int comNumber = computerNumberList.get(i);
            if (comNumber == number && i == order) {
                return 1;
            } else if (comNumber == number && i != order) {
                return 2;
            }
        }
        return 0;
    }
}
