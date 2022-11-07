package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    // 입력이 숫자인가?
    public static boolean isNumber(String s) {
        try {
            int num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // 입력이 3자리 숫자인가?
    public static boolean isThreePosition(Integer n) {
        if (n > 99 && n < 1000) {
            return true;
        } else return false;
    }

    // 서로 다른 세자리 숫자인가?
    public static boolean isDifferent(Integer n) {
        Set<Integer> set = new HashSet<>();

        while (n != 0) {
            set.add(n % 10);
            n /= 10;
        }

        if (set.size() == 3) return true;
        else return false;
    }
}
