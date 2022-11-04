package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Computer {
    private static final int BASEBALL_COUNT = 3;
    private static final int MIN_RANGE_VALUE = 1;
    private static final int MAX_RANGE_VALUE = 9;
    private static final int TO_INDEX = 1;

    private Baseballs answer;

    public Computer() {
    }

    public void generateAnswer() {
        this.answer = Baseballs.of(generateRandomAnswerInput());
    }

    private String generateRandomAnswerInput() {
        StringBuilder generatedRandomAnswerInput = new StringBuilder();
        List<Integer> candidateValues = generateProperRangedCandidateValues();
        int loopCnt = 0;

        while (loopCnt < BASEBALL_COUNT) {
            int selectedValueIndex = Randoms.pickNumberInRange(MIN_RANGE_VALUE - TO_INDEX,
                    candidateValues.size() - TO_INDEX);
            generatedRandomAnswerInput.append(candidateValues.get(selectedValueIndex));
            candidateValues.remove(selectedValueIndex);

            loopCnt++;
        }

        return generatedRandomAnswerInput.toString();
    }

    private List<Integer> generateProperRangedCandidateValues() {
        return IntStream.rangeClosed(MIN_RANGE_VALUE, MAX_RANGE_VALUE)
                .boxed()
                .collect(Collectors.toList());
    }
}
