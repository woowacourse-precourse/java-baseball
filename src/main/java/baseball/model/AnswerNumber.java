package baseball.model;

import baseball.constant.Constant;
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
}
