package baseball;

import java.util.List;

public class ErrorChecker {
    private final int numberSize;
    private final int startInclusive;
    private final int endInclusive;
    private final List<Integer> continueGameInputList;
    private static final String DUPLICATE_NUMBER = "중복된 숫자가 포함되어있습니다.";
    private static final String ILLEGAL_INPUT = "잘못된 값이 입력되었습니다.";
    private static final String ILLEGAL_SIZE = "입력값이 정해진 자릿수가 아닙니다.";

    public ErrorChecker(int numberSize, int startInclusive, int endInclusive, List<Integer> continueGameInputList) {
        this.numberSize = numberSize;
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.continueGameInputList = continueGameInputList;
    }

    public void checkUserNumberError(String input) throws IllegalArgumentException {
        if (isIllegalSize(input)) {
            throw new IllegalArgumentException(ILLEGAL_SIZE);
        }
        if (containIllegalInput(input)) {
            throw new IllegalArgumentException(ILLEGAL_INPUT);
        }
        if (containDuplicateNumber(input)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }
}
