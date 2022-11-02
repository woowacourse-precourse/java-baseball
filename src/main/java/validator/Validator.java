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

    }

    private static boolean isCorrectNumber(String number) {
        char[] digitArray = number.toCharArray();
        for (char digit : digitArray) {
            int boundary = digit - '0'; // 해당 식 결과는 0부터 9 사이의 숫자이여야 한다.
            if (boundary < 0 || boundary > 9) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLengthEqualThree(String number) {
        return number.length() == 3;
    }
}
