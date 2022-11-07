package baseball;

import java.util.HashSet;

public class Validator {
    public static final String LENGTH_EXCEPTION = "3자리 숫자만 입력할 수 있습니다.";
    public static final String HAVING_ANOTHER_CHARACTER_EXCEPTION = "숫자만 포함될 수 있습니다.";
    public static final String HAVING_ZERO_EXCEPTION = "0은 포함될 수 없습니다.";
    public static final String HAVING_SAME_NUMBER_EXCEPTION = "서로 다른 숫자만 입력할 수 있습니다";
    public static final String RESTART_RESPONSE_EXCEPTION = "1, 2 이외의 문자가 입력되었습니다.";

    public static void validateNumberString(String numberStringUserInput) {
        validateLength(numberStringUserInput);
        validateNumber(numberStringUserInput);
        validateNonZero(numberStringUserInput);
        validateDuplicate(numberStringUserInput);
    }

    public static void validateRestartResponse(String replayResponse) {
        if (!replayResponse.equals("1") && !replayResponse.equals("2")) {
            throw new IllegalArgumentException(RESTART_RESPONSE_EXCEPTION);
        }
    }

    public static void validateLength(String numberStringUserInput) {
        if (numberStringUserInput.length() != 3) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION);
        }
    }

    public static void validateNumber(String numberString) {
        for (char numChar : numberString.toCharArray()) {
            if (numChar < '0' || numChar > '9') {
                throw new IllegalArgumentException(HAVING_ANOTHER_CHARACTER_EXCEPTION);
            }
        }
    }

    public static void validateNonZero(String numberString) {
        for (char numChar : numberString.toCharArray()) {
            if (numChar == '0') {
                throw new IllegalArgumentException(HAVING_ZERO_EXCEPTION);
            }
        }
    }

    public static void validateDuplicate(String numberString) {
        HashSet<Character> setForDuplicate = new HashSet<>();
        for (char numChar : numberString.toCharArray()) {
            if (setForDuplicate.contains(numChar)) {
                throw new IllegalArgumentException(HAVING_SAME_NUMBER_EXCEPTION);
            }
            setForDuplicate.add(numChar);
        }
    }
}
