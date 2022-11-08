package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private static final int ANSWER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private List<Integer> answer;

    public Computer() {
        initAnswer();
    }

    public void initAnswer() {
        answer = new ArrayList<>();
    }

    public void generateAnswer() {
        Set<Integer> answerSet = new HashSet<>();

        while (answerSet.size() != ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            answerSet.add(randomNumber);
        }

        initAnswer();

        for (int number : answerSet) {
            answer.add(number);
        }
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
