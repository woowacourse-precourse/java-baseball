package baseball.domain;

public class NumberBall {
    private int number;

    public NumberBall(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (!rangeNumber(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean rangeNumber(int number) {
        return number >= 1 && number <= 9;
    }
}
