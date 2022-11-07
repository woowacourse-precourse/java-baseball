package baseball;

import java.util.HashSet;

public class Validator {

    public static final String LENGTH_EXCEPTION = "3자리 숫자를 입력해야 합니다.";
    public static final String DIGIT_EXCEPTION = "각 자리는 숫자 1~9로 구성되어야 합니다.";
    public static final String DUPLICATION_EXCEPTION = "서로 다른 3개의 숫자로 구성되어야 합니다.";
    public static final String RESPONSE_EXCEPTION = "1 또는 2를 입력해야 합니다.";

    public static void validatePlayerInputNumbersString(String input) {
        validateLength(input);
        validateDigit(input);
        validateNoDuplication(input);
    }

    public static void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION);
        }
    }

    public static void validateDigit(String input) {
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException(DIGIT_EXCEPTION);
            }
        }
    }

    public static void validateNoDuplication(String input) {
        HashSet<Character> inputSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            inputSet.add(c);
        }
        if (inputSet.size() != input.length()) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION);
        }
    }

    public static void validateResponseAfterGame(String response) {
        if (!response.equals("1") && !response.equals("2")) {
            throw new IllegalArgumentException(RESPONSE_EXCEPTION);
        }
    }
}
