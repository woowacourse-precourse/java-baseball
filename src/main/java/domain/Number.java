package domain;

public class Number {
    private final int number;

    public Number(int number) {
        numberRangeValidationTest(number);
        this.number = number;
    }

    private void numberRangeValidationTest(int checkNumber) {
        if (checkNumber < 1) {
            throw new IllegalArgumentException("숫자의 범위가 1 미만입니다.");
        }
        if (9 < checkNumber) {
            throw new IllegalArgumentException("숫자의 범위가 9를 초과합니다.");
        }
    }
}
