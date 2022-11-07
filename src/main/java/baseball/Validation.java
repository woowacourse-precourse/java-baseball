package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    // 입력이 숫자인가?
    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // 입력이 3자리 숫자인가?
    public static boolean isThreePosition(Integer n) {
        return n > 99 && n < 1000;
    }

    // 서로 다른 세자리 숫자인가?
    public static boolean isDifferent(Integer n) {
        Set<Integer> set = new HashSet<>();

        while (n != 0) {
            set.add(n % 10);
            n /= 10;
        }

        return set.size() == 3;
    }

    // 숫자에 0이 포함되는 가?
    public static boolean isContainZero(Integer n) {
        while (n != 0) {
            if (n % 10 == 0) return false;
            n /= 10;
        }
        return true;
    }

    // 재시작에 대한 답변이 옳은 가?
    public static boolean isAnswer(String s) {
        return s.equals("1") || s.equals("2");
    }
}
