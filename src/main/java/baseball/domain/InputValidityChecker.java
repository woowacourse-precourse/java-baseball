package baseball.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class InputValidityChecker {

    public void validateNumberInput(String input, final int MAX_LEN) {
        validLength(input, MAX_LEN);
        validElement(input);
        validContinuity(input, MAX_LEN);
    }

    public void validLength(String input, final int MAX_LEN) {
        if (input.length() != MAX_LEN) {
            throw new IllegalArgumentException("input의 길이가 유효하지 않습니다");
        }
    }

    public void validElement(String input) {
        final String REGEX = "[1-9]+";
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException("input의 구성요소가 0을 제외한 숫자로만 이루어지지 않습니다");
        }
    }

    public void validContinuity(String input, final int MAX_LEN) {
        Set<Character> numSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            numSet.add(input.charAt(i));
        }
        if (numSet.size() != MAX_LEN) {
            throw new IllegalArgumentException("input의 구성요소가 중복됩니다");
        }
    }

    public void validateRepalyGameInput(String input) {
        if (!Objects.equals(input, "1") && !Objects.equals(input, "2")) {
            throw new IllegalArgumentException("1, 또는 2를 입력해야 합니다.");
        }
    }
}
