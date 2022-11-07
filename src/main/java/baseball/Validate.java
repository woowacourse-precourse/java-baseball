package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    public static void check(List<Integer> input) {
        // 중복되는 숫자가 있다면
        if (isDuplicate(input)) {
            throw new IllegalArgumentException("중복되는 숫자가 있습니다.");
        }
        // 3자리 숫자가 아니라면
        if (input.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
        // 0이 포함되어 있다면
        if (input.contains(0)) {
            throw new IllegalArgumentException("0이 포함되어 있습니다.");
        }
    }

    private static boolean isDuplicate(List<Integer> input) {
        Set<Integer> set = new HashSet<>(input);
        return set.size() != input.size();
    }
}
