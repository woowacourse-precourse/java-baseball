package baseball.utils;

import java.util.ArrayList;

public class InputUtil {
    private static final String ISDIGIT_EXCEPTION = "숫자가 아닙니다.";
    private static final String DUPLICATION_EXCEPTION = "중복된 숫자가 존재합니다.";
    private static final String VALID_NUMBER_EXCEPTION = "가능하지 않은 숫자 입니다.";
    private static final String NUMBER_LENGTH_EXCEPTION = "글자의 길이가 초과되었습니다.";
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    public InputUtil() {
    }

    public void checkIsDigit(char number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException(ISDIGIT_EXCEPTION);
        }
    }

    public void checkDuplicationNumber(ArrayList<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION);
        }
    }

    public void checkValidNumber(int number) {
        if (number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException(VALID_NUMBER_EXCEPTION);
        }
    }

    public void checkLength(String number) {
        if (number.length() > 3) {
            throw new IllegalArgumentException(NUMBER_LENGTH_EXCEPTION);
        }
    }

    public int charToInt(char number) {
        return Integer.parseInt(String.valueOf(number));
    }
}
