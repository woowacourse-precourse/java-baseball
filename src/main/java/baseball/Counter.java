package baseball;

public class Counter {

    public static Count calculate(BaseballGameNumber number, BaseballGameNumber otherNumber) {
        return new Count(countBall(number, otherNumber), countStrike(number, otherNumber));
    }
    private static int countStrike(BaseballGameNumber other, BaseballGameNumber otherNumber) {
        int count = 0;
        for (int order = 0; order < BaseballGameNumber.NUMBER_SIZE; order++) {
            if (isSameWhenSameOrder(other, otherNumber, order)) {
                count++;
            }
        }
        return count;
    }

    private static int countBall(BaseballGameNumber number, BaseballGameNumber otherNumber) {
        int count = 0;
        for (int order = 0; order < BaseballGameNumber.NUMBER_SIZE; order++) {
            if (number.contains(otherNumber.numberAt(order)) && !isSameWhenSameOrder(number, otherNumber, order)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isSameWhenSameOrder(BaseballGameNumber number, BaseballGameNumber otherNumber, int order) {
        return number.numberAt(order) == otherNumber.numberAt(order);
    }
}
