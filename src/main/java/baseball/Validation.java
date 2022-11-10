package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    private static boolean isAllDifferent(String number) {
        Set<Character> check = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            check.add(number.charAt(i));
        }
        return check.size() == 3;
    }

    private static boolean isRangeNumeric(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) < '1' || number.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    private static boolean isLengthThree(String number) {
        return number.length() == 3;
    }

    /**
     * 유저가 입력하는 값의 유효성을 판단하는 함수
     */
    public static void validate(String number) {
        if (!isLengthThree(number) || !isRangeNumeric(number) || !isAllDifferent(number)) {
            throw new IllegalArgumentException();
        }
    }
}
