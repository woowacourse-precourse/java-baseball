package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    public static void validateInputNumber(String input) {
        validateInputLength(input, 3);
        validateIsDuplicate(input);
        validateIsNumeric(input, '1', '9');
    }

    public static void validateInputRestart(String input) {
        validateInputLength(input, 1);
        validateIsNumeric(input, '1', '2');
    }

    private static void validateInputLength(String input, int rightLength) {
        if (input.length() != rightLength) {
            throw new IllegalArgumentException("길이가 "+ rightLength + "인 수를 입력해주세요.");
        }
    }

    private static void validateIsDuplicate(String input) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            characterSet.add(input.charAt(i));
        }
        if (characterSet.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자를 입력하지 말아주세요.");
        }
    }

    private static void validateIsNumeric(String input, char startNum, char endNum) {
        for (int i = 0; i < 3; i++) {
            checkIsDigit(input.charAt(i), startNum, endNum);
        }
    }

    private static void checkIsDigit(char input, char startNum, char endNum) {
        if (input < startNum || input > endNum) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

}
