package baseball.exception;

import static java.util.regex.Pattern.*;

public class InputException {

    // 숫자가 아닌 것이 포함된 경우 (공백 포함)
    public static Boolean containsNonDigit(String inputNumber) {
        String pattern = "^[0-9]*$";
        if (!matches(pattern, inputNumber)) return true;
        return false;
    }

    // 세 자리 숫자가 아닌 경우
    // 중복된 숫자가 있는 경우
    // 빈 문자열인 경우

}
