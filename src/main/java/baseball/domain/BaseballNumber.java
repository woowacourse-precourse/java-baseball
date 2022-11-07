package baseball.domain;

public class BaseballNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private static final String INPUT_NUMBER_RANGE_EXCEPTION_MESSAGE = "1~9 사이으 숫자를 입력해야 합니다.";
    private final int ballNumber;

    public BaseballNumber(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    private void validateBallNumber(int ballNumber) {
        if (ballNumber < MIN_NUMBER || ballNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(INPUT_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }
}
