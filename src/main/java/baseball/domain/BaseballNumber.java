package baseball.domain;

public class BaseballNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private final int ballNumber;
    BaseballNumber(int ballNumber){
        this.ballNumber = ballNumber;
    }
}
