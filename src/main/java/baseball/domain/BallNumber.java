package baseball.domain;

public class BallNumber {
    private final int number;
    
    public BallNumber(final String number) {
        this(Integer.parseInt(number));
    }
    
    public BallNumber(final int number) {
        this.number = number;
    }
}
