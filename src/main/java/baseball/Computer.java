package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Computer {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int MAX_LENGTH = 3;

    private List<Integer> answer;

    public Computer() {
        setRandomAnswer();
    }

    public void setRandomAnswer() {
        Set<Integer> answerSet = new HashSet<>();
        while (answerSet.size() < MAX_LENGTH) {
            int nextAnswer = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            answerSet.add(nextAnswer);
        }
        answer = new ArrayList<>(answerSet);
    }

    public Result compareAnswer(List<Integer> playerAnswer) {
        validateAnswer(playerAnswer);

        int strikeCount = 0;
        int ballCount = 0;

        for (int index = 0; index < playerAnswer.size(); index++) {
            if (Objects.equals(answer.get(index), playerAnswer.get(index))) {
                strikeCount += 1;
            } else if (answer.contains(playerAnswer.get(index))) {
                ballCount += 1;
            }
        }
        return new Result(strikeCount, ballCount);
    }

    private void validateAnswer(List<Integer> answer) {
        if (answer.size() != MAX_LENGTH) {
            throw new IllegalArgumentException("입력 가능한 최대 자릿수를 초과했습니다.");
        }

        Set<Integer> answerSet = new HashSet<>(answer);
        if (answerSet.size() != MAX_LENGTH) {
            throw new IllegalArgumentException("중복되지 않은 숫자만 입력 가능합니다.");
        }

        for (Integer ans : answer) {
            if (ans < MIN_VALUE || ans > MAX_VALUE) {
                throw new IllegalArgumentException("각 자리수의 입력 가능한 값 범위를 벗어났습니다.");
            }
        }
    }
}
