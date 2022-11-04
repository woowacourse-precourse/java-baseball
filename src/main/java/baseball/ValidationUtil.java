package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static baseball.ConstVariable.*;

public class ValidationUtil {

    public static boolean isValidRange(List<Integer> list) {
        return list.stream().filter(m -> m >= MIN && m <= MAX).count() == list.size();
    }

    public static boolean isValidCount(List<Integer> list) {
        return list.size() == VALID_CNT;
    }

    public static boolean haveNoDuplicatedNum(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        return list.size() == set.size();
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
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            result.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        return result;
    }
}
