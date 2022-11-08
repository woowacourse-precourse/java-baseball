package baseball.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static baseball.domain.ConstVariable.*;

public class ValidationUtil {

    public static boolean isValidRange(List<Integer> list) {
        return list.stream()
                .filter(m -> m >= MIN && m <= MAX)
                .count() == list.size();
    }

    public static boolean isValidCount(List<Integer> list) {
        return list.size() == VALID_CNT;
    }

    public static boolean haveNoDuplicatedNum(List<Integer> list) {
        return list.size() ==  new HashSet<>(list).size();
    }

    public static void isValid(List<Integer> list) {
        if (!isValidRange(list)) {
            throw new IllegalArgumentException("입력값이 범위를 초과하셨습니다.");
        }
        if (!isValidCount(list)) {
            throw new IllegalArgumentException("입력값이 세자리가 아닙니다.");
        }
        if (!haveNoDuplicatedNum(list)) {
            throw new IllegalArgumentException("입력값이 중복되었습니다.");
        }
    }

    public static List<Integer> mapStringToList(String str) {
        if (!isAlphabetic(str)) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다.");
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            result.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        isValid(result);
        return result;
    }

    private static boolean isAlphabetic(String str) {
        int i = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            i++;
        }
        return str.length() == i;
    }
}
