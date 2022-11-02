package baseball.controller;

import baseball.system.AnswerHolder;
import baseball.vo.Answer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class ComputerController {
    public void createAnswer() {
        Set<Integer> numberHolder = new LinkedHashSet<>();
        while (numberHolder.size() != 3) {
            numberHolder.add(Randoms.pickNumberInRange(1, 9));
        }

        AnswerHolder.setAnswer(Answer.of(numberHolder));
    }
}
