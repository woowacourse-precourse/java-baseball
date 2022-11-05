package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {
    private final static int MINIMUM_RANGE = 1;
    private final static int MAXIMUM_RANGE = 9;
    private final static int DIGIT_SIZE = 3;

    private List<Integer> value;

    public Answer() {
        value = answerGenerator();
    }

    private List<Integer> answerGenerator() {
        List<Integer> newAnswer = new ArrayList<>();

        while (newAnswer.size() < DIGIT_SIZE) {
            addUniqueNumberOnly(newAnswer);
        }
        return newAnswer;
    }

    private void addUniqueNumberOnly(List<Integer> list) {
        int newNumber = Randoms.pickNumberInRange(MINIMUM_RANGE, MAXIMUM_RANGE);

        if (!list.contains(newNumber)) {
            list.add(newNumber);
        }
    }

    public List<Integer> getValue() {
        return value;
    }


}
