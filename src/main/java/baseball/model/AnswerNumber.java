package baseball.model;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;

public class AnswerNumber {
    private String answer;

    public AnswerNumber() {

    }
    public String getAnswer() {

        return this.answer;
    }

    public void getNewAnswer() {

        LinkedHashSet<String> createAnswerNumber = new LinkedHashSet<>();
        while (createAnswerNumber.size() < Constant.NUMBER_SIZE) {
            createAnswerNumber.add(getRandomNumber());
        }
        this.answer = String.join("", createAnswerNumber);
    }

    public String getRandomNumber() {

        return Integer.toString(Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER));
    }
}
