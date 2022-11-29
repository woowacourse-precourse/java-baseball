package baseball.model;

import java.util.List;

public class Computer {

    private List<Integer> answer;

    public List<Integer> setAnswer(List<Integer> answer) {
        this.answer = answer;
        return answer;
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}