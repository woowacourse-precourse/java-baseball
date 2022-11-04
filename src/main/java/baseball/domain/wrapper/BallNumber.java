package baseball.domain.wrapper;

public class BallNumber {

    private int number;

    private BallNumber(int number) {
        if (isBallNumber(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    private boolean isBallNumber(int number) {
        return number < 1 || number > 9;
    }

    public static BallNumber from(int number) {
        return new BallNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BallNumber)) {
            return false;
        }

        BallNumber that = (BallNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
