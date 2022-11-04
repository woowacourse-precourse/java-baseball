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

    private int duplicateCount(String input, char word) {
        int count = 0;
        for (int index = 0; index < input.length(); index++) {
            if (word == input.charAt(index)) {
                count++;
            }
        }
        return count;
    }

    private boolean containDuplicateNumber(String input) {
        for (int index = 0; index < input.length(); index++) {
            char word = input.charAt(index);

            if (duplicateCount(input, word) > 1) {
                return true;
            }
        }
        return false;
    }

    private boolean containIllegalInput(String input) {
        for (int index = 0; index < input.length(); index++) {
            char digit = input.charAt(index);
            int number = Character.getNumericValue(digit);

            if (!(number >= startInclusive && number <= endInclusive)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIllegalSize(String input) {
        return input.length() != numberSize;
    }

    public void checkContinueGameError(String input) throws IllegalArgumentException {
        if (isIllegalContinueGameInput(input)) {
            throw new IllegalArgumentException(ILLEGAL_INPUT);
        }
    }
}
