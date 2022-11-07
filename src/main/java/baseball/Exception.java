package baseball;

import java.util.List;
import java.util.Objects;

public class Exception {
    public static void isOverThreeDigit(List<Integer> list) {
        if (list.size() != 3) {
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }
    }

    public static void isSameNum(List<Integer> list) {
        if (Objects.equals(list.get(0), list.get(1))) {
            throw new IllegalArgumentException("1번째 자리와 2번째 자리가 같음");
        }
        if (Objects.equals(list.get(1), list.get(2))) {
            throw new IllegalArgumentException("2번째 자리와 3번째 자리가 같음");
        }
        if (Objects.equals(list.get(0), list.get(2))) {
            throw new IllegalArgumentException("1번째 자리와 3번째 자리가 같음");
        }
    }

    public static void isNumber(String s) {
        if (!Character.isDigit(s.charAt(0))) {
            throw new IllegalArgumentException("1번째 단어가 숫자가 아닙니다.");
        }
        if (!Character.isDigit(s.charAt(1))) {
            throw new IllegalArgumentException("2번째 단어가 숫자가 아닙니다.");
        }
        if (!Character.isDigit(s.charAt(2))) {
            throw new IllegalArgumentException("3번째 단어가 숫자가 아닙니다.");
        }
    }
}
