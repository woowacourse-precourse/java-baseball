package baseball;

import java.util.List;

public class ValidationUtil {

    public static final int VALID_CNT = 3;

    public static boolean isValidRange(List<Integer> list) {
        return list.stream().filter(m -> m >= 1 && m <= 9).count() == list.size();
    }

    public static boolean isValidCount(List<Integer> list) {
        return list.size() == VALID_CNT;
    }
}
