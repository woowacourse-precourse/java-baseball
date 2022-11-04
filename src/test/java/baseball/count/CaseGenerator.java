package baseball.count;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CaseGenerator {

    String createBallCase(List<Integer> answer) {
        List<Integer> result = new ArrayList<>(answer);

        int size = result.size();
        int maxIdx = result.size() - 1;

        for (int idx = 0; idx < size / 2; idx++) {
            int temp = result.get(idx);
            int nextIdx = maxIdx - idx;

            result.set(idx, result.get(nextIdx));
            result.set(nextIdx, temp);
        }

        if (size % 2 != 0) {
            int centerIdx = size / 2;
            int temp = result.get(centerIdx);

            result.set(centerIdx, result.get(centerIdx + 1));
            result.set(centerIdx + 1, temp);
        }

        return result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    String mixedCase(List<Integer> answer, int strikeCount) {
        ArrayList<Integer> result = new ArrayList<>(answer);

        // 넘겨받은 개수는 변경하지 않는다.
        return "";
    }
}
