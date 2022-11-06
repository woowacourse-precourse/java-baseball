package baseball;

import java.util.HashSet;
import java.util.Set;

public class CheckException {
    private static final int LIMIT_LENGTH = 3;
    private static final String PROMPT_ERROR_MESSAGE = "에러 발생, 조건을 다시 확인하세요.";

    public static void validationNumber(String inputNum) {
        if (!(checkNumberLength(inputNum) && checkNumeric(inputNum) && checkDuplicateNumber(inputNum))) {
            throw new IllegalArgumentException(PROMPT_ERROR_MESSAGE);
        }
    }

    public static boolean checkNumberLength(String checkNum) {
        return checkNum.length() == LIMIT_LENGTH;
    }

    public static boolean checkNumeric(String checkNum) {
        try {
            Integer.parseInt(checkNum);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean checkDuplicateNumber(String checkNum) {
        Set<Character> inputSet = new HashSet<>();
        for (int i = 0; i < LIMIT_LENGTH; i++) {
            inputSet.add(checkNum.charAt(i));
        }
        return inputSet.size() == checkNum.length();
    }

    public static void checkRestartNumber(String checkNum) {
        if ("1".equals(checkNum) || "2".equals(checkNum)) {
            return;
        }
        throw new IllegalArgumentException(PROMPT_ERROR_MESSAGE);
    }
}

