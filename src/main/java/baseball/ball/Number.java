package baseball.ball;

public final class Number {
    private static final int MINIMUM_NUM_RANGE = 1;
    private static final int MAXIMUM_NUM_RANGE = 9;
    private final int number;

    public Number(int number) {
        validateNumRange(number);
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    private void validateNumRange(int number) {
        if (number < MINIMUM_NUM_RANGE || MAXIMUM_NUM_RANGE < number) {
            throw new IllegalArgumentException("Ball의 number 범위를 벗어났습니다. num: " + number);
        }
    }
}
