package baseball.domain;

public class BallNumber {

    public static final int MIN_BALL_NUMBER = 1;

    public static final int MAX_BALL_NUMBER = 9;

    private final int number;

    public BallNumber(final int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(final int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("야구 숫자는 1~9까지만 가능합니다.");
        }
    }

    private boolean isOutOfRange(final int number) {
        return MIN_BALL_NUMBER > number || number > MAX_BALL_NUMBER;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        BallNumber other = (BallNumber) obj;
        return this.number == other.number;
    }
}
