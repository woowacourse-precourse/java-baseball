package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Computer {

    private static final int ANSWER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBEr = 9;
    private final int[] answer;

    public Computer() {
        answer = new int[ANSWER_LENGTH];
    }

    public void generateAnswer() {
        Set<Integer> answerSet = new HashSet<>();

        while (answerSet.size() != ANSWER_LENGTH) {
            answerSet.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBEr));
        }

        int index = 0;

        for (int number : answerSet) {
            answer[index] = number;
            index++;
        }
    }

    public int[] getAnswer() {
        return answer;
    }
}
