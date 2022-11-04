package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private static final Integer MIN_VALUE = 1;
    private static final Integer MAX_VALUE = 9;
    private static final Integer ANSWER_LENGTH = 3;

    private List<Integer> answer;

    public Computer() {
        init();
    }

    private void init() {
        answer = Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, ANSWER_LENGTH);
    }

    private void validateAnswer(List<Integer> answer) {
        if (answer.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
        }

        Set<Integer> answerSet = new HashSet<>(answer);
        if (answerSet.size() != 3) {
            throw new IllegalArgumentException("중복되지 않은 숫자만 입력 가능합니다.");
        }

        for (Integer ans : answer) {
            if (ans < MIN_VALUE || ans > MAX_VALUE) {
                throw new IllegalArgumentException("각 자리수는 1부터 9까지의 숫자만 입력 가능합니다.");
            }
        }
    }
}
