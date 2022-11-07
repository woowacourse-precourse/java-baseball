package baseball.controller;

import baseball.system.holder.AnswerHolder;
import baseball.vo.Answer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class ComputerController {
    public void createAnswer() {
        try {
            Answer answer = makeAnswer();
            AnswerHolder.setAnswer(answer);
        } catch (IllegalArgumentException e) {
            createAnswer();
        }
    }

    private Answer makeAnswer() {
        Set<Integer> numberHolder = new LinkedHashSet<>();
        while (numberHolder.size() != Answer.ANSWER_SIZE) {
            numberHolder.add(Randoms.pickNumberInRange(Answer.MIN_ANSWER_VALUE, Answer.MAX_ANSWER_VALUE));
        }

        return Answer.of(numberHolder);
    }
}
