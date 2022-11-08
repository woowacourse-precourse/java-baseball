package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Answer implements Number {
    List<Integer> number;

    @Override
    public void create() {
        List<Integer> newAnswer = new ArrayList<>();
        while (newAnswer.size() < MAX_SIZE) {
            int number = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!newAnswer.contains(number)) {
                newAnswer.add(number);
            }
        }
        number = newAnswer;
    }

    @Override
    public List<Integer> get() {
        return number;
    }
}
