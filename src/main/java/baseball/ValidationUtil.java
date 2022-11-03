package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ValidationUtil {

    public static final int MIN = 1;
    public static final int MAX = 9;
    public static final int VALID_CNT = 3;

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
        if (!isValidRange(list) || !isValidCount(list) || !haveNoDuplicatedNum(list)) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    public static List<Integer> mapStringToList(String str) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            result.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        isValid(result);
        return result;
    }
}
