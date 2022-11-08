package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class InputException {
    private static final String PERMIT_NUMBER = "[1-9]+";
    private static final int SIZE = 3;

    public void isInputValid(String input) {
        isSizeOK(input);
        isRangeOK(input);
        isUnique(input);
    }

    public void isSizeOK(String input) {
        if (input.length() != SIZE) {
            throw new IllegalArgumentException("3개의 수를 입력해주세요.");
        }
    }

    public void isRangeOK(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!checkRange(input)) {
                throw new IllegalArgumentException("1~9의 숫자만 입력해주세요.");
            }
        }
    }

    public void isUnique(String input) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            numSet.add(input.charAt(i) - '0');
        }
        if (!checkSize(numSet)) {
            throw new IllegalArgumentException("중복되지 않은 수를 입력해주세요.");
        }
    }

    public boolean checkRange(String input) {
        return input.matches(PERMIT_NUMBER);
    }

    public boolean checkSize(Set<Integer> numSet) {
        return numSet.size() == SIZE;
    }
}
