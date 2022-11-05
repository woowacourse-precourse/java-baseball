package baseball;

public class Counter {
    public static int getStrikeCount(BaseballGameNumber actual, BaseballGameNumber expected) {
        int count = 0;
        for (int order = 0; order < BaseballGameNumber.NUMBER_SIZE; order++) {
            if (isSameWhenSameOrder(actual, expected, order)) {
                count++;
            }
        }
        return count;
    }

    public static int getBallCount(BaseballGameNumber actual, BaseballGameNumber expected) {
        int count = 0;
        for (int order = 0; order < BaseballGameNumber.NUMBER_SIZE; order++) {
            if (actual.contains(expected.numberAt(order)) && !isSameWhenSameOrder(actual, expected, order)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isSameWhenSameOrder(BaseballGameNumber actual, BaseballGameNumber expected, int order) {
        return actual.numberAt(order) == expected.numberAt(order);
    }
}
