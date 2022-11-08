package baseball;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BaseballValidator {

    public static void validDateSelectOption(String selectOption) {
        if (!(selectOption.equals("1") || selectOption.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2를 선택해야 합니다");
        }
    }

    public static void validateBaseballNumber(String baseballNumber) {
        String pattern = "^[0-9]*$"; // 숫자만 등장하는지
        if (baseballNumber.length() > 3) {
            throw new IllegalArgumentException("3자리 정수를 입력해야합니다.");
        }
        if (!Pattern.matches(pattern, baseballNumber)) {
            throw new IllegalArgumentException("정수만 포함되어야 합니다.");
        }
        hasDuplicateNumbers(baseballNumber);

    }

    public static void hasDuplicateNumbers(String baseballNumber) {

        long count = Arrays.stream(baseballNumber.split(""))
                           .distinct()
                           .count();
        if (count != 3) {
            throw new IllegalArgumentException("서로 다른 정수를 입력해야 합니다.");
        }

    }
}
