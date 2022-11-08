package baseball.exception;

public class PlayException {
    private static final String PERMIT_RANGE = "[1-2]+";

    public void askAfterResultException(String input) {
        checkSize(input);
        checkRange(input);
    }

    public void checkSize(String input) {
        if (!isSizeOK(input)) {
            throw new IllegalArgumentException("하나의 숫자만 입력하셔야 합니다.");
        }
    }

    public void checkRange(String endingInput) {
        if (!isRangeOK(endingInput)) {
            throw new IllegalArgumentException("1~2 까지의 숫자만 입력하셔야합니다.");
        }
    }

    public boolean isSizeOK(String input) {
        return input.length() == 1;
    }

    public boolean isRangeOK(String input) {
        return input.matches(PERMIT_RANGE);
    }
}
