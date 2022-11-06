package baseball;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    public static final String INVALID_LENGTH_ERROR_MSG ="입력의 길이가 3이 아닙니다.";
    public static final String INVALID_FORMAT_ERROR_MSG ="입력이 숫자 형식이 아닙니다.";
    public static final String DUPLICATE_NUMBER_ERROR_MSG ="서로 다른 수로 이루어진 3자리의 수가 아닙니다.";
    public static final String INVALID_RESTART_FORMAT_MSG ="입력이 1이나 2가 아닙니다.";


    public boolean checkIllegalGameInput(String str) {
        if (!isValidLength(str)) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MSG);
        }

        if (!isNumberFormat(str)) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR_MSG);
        }

        if (isDuplicateNumber(str)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MSG);
        }

        return true;
    }

    private boolean isValidLength(String str) {
        return str.length() == 3;
    }

    private boolean isNumberFormat(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isNumber(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

    private boolean isDuplicateNumber(String str) {
        Set<Character> numberSet = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);

            if (numberSet.contains(curChar)) {
                return true;
            }

            numberSet.add(curChar);
        }

        return false;
    }

    public boolean checkIllegalRestartInput(String str) {
        if (!isValidRestartFormat(str)) {
            throw new IllegalArgumentException(INVALID_RESTART_FORMAT_MSG);
        }

        return true;
    }

    private boolean isValidRestartFormat(String str) {
        return str.equals("1") || str.equals("2");
    }
}
