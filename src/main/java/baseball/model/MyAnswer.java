package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class MyAnswer {
    private List<Integer> answer;

    public MyAnswer(int number) {
        setAnswer(number);
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(int number) {
        this.answer = new ArrayList<>();
        while(number > 0) {
            answer.add(0,number % 10);
            number /= 10;
        }
    }

}
