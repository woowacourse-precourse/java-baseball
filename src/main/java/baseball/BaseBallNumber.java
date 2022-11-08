package baseball;

public class BaseBallNumber {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private final int baseballNumber;

    public BaseBallNumber(Character number) {
        this(Character.getNumericValue(number));
    }

    public BaseBallNumber(String number) {
        this(Integer.parseInt(number));
    }

    public BaseBallNumber(Integer number) {
        this.baseballNumber = number;
    }

    public int getValue() {
        return baseballNumber;
    }
}