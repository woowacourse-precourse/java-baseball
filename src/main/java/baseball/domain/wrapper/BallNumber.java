package baseball.domain.wrapper;

public class BallNumber {

    private int number;

    private BallNumber(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public static BallNumber from(int number) {
        return new BallNumber(number);
    }

}
