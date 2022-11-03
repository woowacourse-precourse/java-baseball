package baseball;

import java.util.List;

public class ValidationUtil {
    public static boolean isValidRange(List<Integer> list) {
        return list.stream().filter(m -> m >= 1 && m <= 9).count() == list.size();
    }
}
