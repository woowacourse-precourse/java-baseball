package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private static final int ANSWER_NUMBERS_SIZE = 3;
    private static final String SIZE_ERROR = "정답은 3자리 수만 가능합니다.";
    private static final String DUPLICATE_ERROR = "정답에 중복된 수는 포함될 수 없습니다.";

    private List<Integer> answerNumbers;

    public Computer(List<Integer> answerNumbers) {
        validateSize(answerNumbers);
        validateDuplicate(answerNumbers);
        this.answerNumbers = answerNumbers;
    }

    private void validateSize(List<Integer> answerNumbers) {
        if (answerNumbers.size() != ANSWER_NUMBERS_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    private void validateDuplicate(List<Integer> answerNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(answerNumbers);
        if (nonDuplicateNumbers.size() != ANSWER_NUMBERS_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }
}
