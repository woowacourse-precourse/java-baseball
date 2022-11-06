package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class InputNumbersException {
    private static final String ONLY_NUMBER_REGEX = "[1-9]+";
    private static final int REQUIRE_NUMBER_SIZE = 3;

    public void isContainedOnlyNumber(String numberTypeOfString) {
        for (int i = 0; i < numberTypeOfString.length(); i++) {
            if (!numberTypeOfString.matches(ONLY_NUMBER_REGEX)) {
                throw new IllegalArgumentException("1~9의 숫자만 입력해주세요.");
            }
        }
    }

    public void isOverlapNumber(String numberTypeOfString) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < numberTypeOfString.length(); i++) {
            numSet.add(numberTypeOfString.charAt(i) - '0');
        }
        if (numSet.size() != REQUIRE_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요.");
        }
    }
}
