package baseball.exception;

import static java.util.regex.Pattern.*;

public class InputException {

    public static void validateInputNumber(String inputNumber) throws RuntimeException {
        if (isEmptyInput(inputNumber) || containsNonDigit(inputNumber)
                || isNotThreeDigits(inputNumber) || containsDuplicateDigits(inputNumber)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    // 숫자가 아닌 것이 포함된 경우 (공백 포함)
    public static Boolean containsNonDigit(String inputNumber) {
        String pattern = "^[0-9]*$";
        if (!matches(pattern, inputNumber)) return true;
        return false;
    }

    // 세 자리 숫자가 아닌 경우
    public static Boolean isNotThreeDigits(String inputNumber) {
        if (inputNumber.length() != 3) return true;
        return false;
    }

    // 중복된 숫자가 있는 경우
    public static Boolean containsDuplicateDigits(String inputNumber) {
        char first = inputNumber.charAt(0);
        char second = inputNumber.charAt(1);
        char third = inputNumber.charAt(2);

        if (first == second) return true;
        if (second == third) return true;
        if (third == first) return true;
        return false;
    }

    // 빈 문자열인 경우
    public static Boolean isEmptyInput(String inputNumber) {
        if (inputNumber.isEmpty()) return true;
        return false;
    }

}
