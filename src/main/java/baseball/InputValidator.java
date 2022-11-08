package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final int BEGIN_NUMBER_RANGE = 1;
    private static final int END_NUMBER_RANGE = 9;
    private static final int MAX_NUMBER_OF_DIGITS = 3;

    private static final String REGEX = "";
    private static final String NON_NUMERIC_VALUE_EXCEPTION_MESSAGE = "숫자가 아닌 값을 입력하였습니다.";
    private static final String INVALID_NUMBER_EXCEPTION_MESSAGE =
            BEGIN_NUMBER_RANGE + "부터 " + END_NUMBER_RANGE + "까지 서로 다른 수로 이루어진 " + MAX_NUMBER_OF_DIGITS
                    + "자리의 숫자를 입력해야 합니다.";
    private static final String INVALID_USER_ANSWER_EXCEPTION_MESSAGE = "잘못된 명령어를 입력하셨습니다.";

    public static void validateNumber(String inputValue) {
        checkNonNumericValue(inputValue);
        checkInvalidNumber(inputValue);
    }

    private static void checkInvalidNumber(String inputValue) {
        Set<Integer> digits = new HashSet<>();

        splitNumber(inputValue, digits);

        if (!isValidNumber(digits)) {
            throw new IllegalArgumentException(INVALID_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static void splitNumber(String inputValue, Set<Integer> digits) {
        for (String digit : inputValue.split(REGEX)) {
            digits.add(Integer.valueOf(digit));
        }
    }

    private static boolean isValidNumber(Set<Integer> digits) {
        return digits.stream().filter(InputValidator::isValidNumberRange).count() == MAX_NUMBER_OF_DIGITS;
    }

    private static boolean isValidNumberRange(Integer digit) {
        return digit >= BEGIN_NUMBER_RANGE && digit <= END_NUMBER_RANGE;
    }

    private static void checkNonNumericValue(String inputValue) {
        if (!isNumber(inputValue)) {
            throw new IllegalArgumentException(NON_NUMERIC_VALUE_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNumber(String inputValue) {
        return inputValue.chars().allMatch(Character::isDigit);
    }

    public static void executeUserAnswerException() {
        throw new IllegalArgumentException(INVALID_USER_ANSWER_EXCEPTION_MESSAGE);
    }
}
