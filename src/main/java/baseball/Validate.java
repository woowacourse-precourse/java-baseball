package baseball;

import java.util.List;

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
        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = i + 1; j < input.size(); j++) {
                if (input.get(i).equals(input.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
