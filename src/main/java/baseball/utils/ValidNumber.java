package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class ValidNumber {
    private static String THREE_INPUT_MSG = "3자리 숫자를 입력해주세요.";
    private static String OTHER_INPUT_MSG = "서로 다른 숫자를 입력해주세요.";
    private static String CORRECT_RESTART_INPUT_MSG = "1 또는 2의 숫자를 입력해주세요";

    private static int NUMBER_LENGTH = 3;
    private static String CONTINUE = "1";
    private static String EXIT = "2";

    public static void validUserNumber(String baseballNumber) {
        validUserBaseballNumberLength(baseballNumber);
        validUserBaseballNumberOther(baseballNumber);
    }

    private static void validUserBaseballNumberLength(String baseballNumber) {
        if (baseballNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(THREE_INPUT_MSG);
        }
    }

    private static void validUserBaseballNumberOther(String baseballNumber) {
        Set<Character> userNumber = new HashSet<>();
        for (int i = 0; i < baseballNumber.length(); i++) {
            if (!userNumber.contains(baseballNumber.charAt(i))) {
                userNumber.add(baseballNumber.charAt(i));
            } else {
                throw new IllegalArgumentException(OTHER_INPUT_MSG);
            }
        }
    }

    public static boolean validRestartNumber(String number) {
        if (number.equals(CONTINUE)) {
            return true;
        }
        if (number.equals(EXIT)) {
            return false;
        }
        throw new IllegalArgumentException(CORRECT_RESTART_INPUT_MSG);
    }
}
