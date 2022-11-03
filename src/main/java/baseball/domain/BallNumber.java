package baseball.domain;

public class BallNumber {
    private final int ballNumber;

    public BallNumber(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return ballNumber == that.ballNumber;
    }
}
