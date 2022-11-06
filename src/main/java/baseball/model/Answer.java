package baseball.model;

import baseball.system.SystemValue;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Integer> value;

    public Answer() {
        value = answerGenerator();
    }

    private List<Integer> answerGenerator() {
        List<Integer> newAnswer = new ArrayList<>();

        while (newAnswer.size() < SystemValue.DIGIT_SIZE) {
            addUniqueNumberOnly(newAnswer);
        }
        return newAnswer;
    }

    private void addUniqueNumberOnly(List<Integer> list) {
        int newNumber = Randoms.pickNumberInRange(SystemValue.MINIMUM_RANGE, SystemValue.MAXIMUM_RANGE);

        if (!list.contains(newNumber)) {
            list.add(newNumber);
        }
    }

    public List<Integer> getValue() {
        return value;
    }
}
