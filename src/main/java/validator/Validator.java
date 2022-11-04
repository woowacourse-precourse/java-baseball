package validator;

import constant.ErrorMessage;
import constant.GuideMessage;

public class Validator {
    public static void checkStartOrEndInput(String input) throws IllegalArgumentException {
        if (input.equals(GuideMessage.ONE) || input.equals(GuideMessage.TWO)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_START_OR_END);
    }

    public static void checkInputNumber(String number) throws IllegalArgumentException {
        if (!isCorrectNumber(number)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_NUMBER);
        }
        if (!isLengthEqualThree(number)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_LENGTH);
        }
        if (!isDuplicatedNumber(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER);
        }
    }

    public static boolean isCorrectNumber(String number) {
        char[] digitArray = number.toCharArray();
        for (char digit : digitArray) {
            int boundary = digit - '0'; // 해당 식 결과는 0부터 9 사이의 숫자이여야 한다.
            if (boundary < 0 || boundary > 9) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLengthEqualThree(String number) {
        return number.length() == 3;
    }

    public static boolean isDuplicatedNumber(String number) {
        int[] numberCount = new int[10]; //  0~9 까지 반복된 횟수를 셀 수 있는 배열 생성
        for (int i=0; i<number.length(); i++) {
            int index = number.charAt(i) - '0';
            numberCount[index]++;
        }
        for (int count : numberCount) {
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
