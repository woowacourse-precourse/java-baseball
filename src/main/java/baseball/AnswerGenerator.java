package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Const.NUMBER_LENGTH;


public class AnswerGenerator {

    private List<Integer> answer;

    public AnswerGenerator() {
        answer  = new ArrayList<>();
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void generateAnswer() {
        while (answer.size() < NUMBER_LENGTH) {
            int randomNumber = (int) (Math.random() * 9) + 1;

            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }
}
