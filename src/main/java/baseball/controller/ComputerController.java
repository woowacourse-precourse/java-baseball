package baseball.controller;

import baseball.system.AnswerHolder;
import baseball.vo.Answer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class ComputerController {
    public void createAnswer() {
        try {
            Set<Integer> numberHolder = new LinkedHashSet<>();
            while (numberHolder.size() != Answer.ANSWER_LIST_SIZE) {
                numberHolder.add(Randoms.pickNumberInRange(Answer.MIN_ANSWER_VALUE, Answer.MAX_ANSWER_VALUE));
            }

            AnswerHolder.setAnswer(Answer.of(numberHolder));
        } catch (IllegalArgumentException e) {
            createAnswer();
        }
    }
}
