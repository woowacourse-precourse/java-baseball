package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class InputException {
    private static final String PERMIT_NUM = "[1-9]+";
    private static final int REQUIRE_NUMBER_SIZE = 3;

    public void isInputValid(String input) {
        isNumberSizeEqualsThree(input);
        isContainedOnlyNumber(input);
        isOverlapNumber(input);
    }

    public void isNumberSizeEqualsThree(String input) {
        if (input.length() != REQUIRE_NUMBER_SIZE) {
            throw new IllegalArgumentException("3개의 수를 입력해주세요.");
        }
    }

    public void isContainedOnlyNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!isUserInputContainsOnlyNumber(input)) {
                throw new IllegalArgumentException("1~9의 숫자만 입력해주세요.");
            }
        }
    }

    public void isOverlapNumber(String input) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            numSet.add(input.charAt(i) - '0');
        }
        if (!isNumSetSizeEqualsPermittedSize(numSet)) {
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요.");
        }
    }

    public boolean isUserInputContainsOnlyNumber(String input) {
        if (input.matches(PERMIT_NUM)) {
            return true;
        }
        return false;
    }

    public boolean isNumSetSizeEqualsPermittedSize(Set<Integer> numSet) {
        if (numSet.size() == REQUIRE_NUMBER_SIZE) {
            return true;
        }
        return false;
    }
}