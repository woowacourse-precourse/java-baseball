package baseball.Util;

import java.util.List;

public class Valid {
    private static final boolean VALID = true;
    private static final boolean INVALID = false;

    public static boolean validNumberList(List<Integer> numberList) {
        if (numberList.size() != 3) {
            return INVALID;
        }
        if (numberList.get(0) == numberList.get(1)
                || numberList.get(1) == numberList.get(2)
                || numberList.get(0) == numberList.get(2)
        ) return INVALID;

        return VALID;
    }
}
