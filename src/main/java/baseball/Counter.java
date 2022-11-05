package baseball;

public class Counter {
    public static int getStrikeCount(BaseballGameNumber actual, BaseballGameNumber expected) {
        int count = 0;
        for (int order = 0; order < BaseballGameNumber.NUMBER_SIZE; order++) {
            if (actual.numberAt(order) == expected.numberAt(order)) {
                count++;
            }
        }
        return count;
    }

    public static int getBallCount(BaseballGameNumber actual, BaseballGameNumber expected) {
        return 0;
    }
}
