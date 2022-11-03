package baseball;

public class BallNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String NUMBER_OUT_OF_RANGE = "야구 번호가 범위(1~9)밖에 있습니다.";
    private int number;

    public BallNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE);
        }
    }
}