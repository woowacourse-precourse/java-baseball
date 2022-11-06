package baseball.exception;

public class AfterGamePlayException {
    private static final String PERMIT_NUMBER_REGEX = "[1-2]+";
    private static final int PERMIT_NUMBER_LENGTH = 1;

    public void isRightLength(String numberTypeOfString) {
        if (numberTypeOfString.length() != PERMIT_NUMBER_LENGTH) {
            throw new IllegalArgumentException("하나의 숫자만 입력하셔야 합니다.");
        }
    }

    public void isRightNumber(String numberOfString) {
        if (!numberOfString.matches(PERMIT_NUMBER_REGEX)) {
            throw new IllegalArgumentException("1~2 까지의 숫자만 입력하셔야합니다.");
        }
    }
}
