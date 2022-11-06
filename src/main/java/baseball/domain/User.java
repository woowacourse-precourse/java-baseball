package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    final static int MAX_SIZE = 3;
    private List<Integer> userAnswer;

    public User() {
        this.userAnswer = new ArrayList<>();
    }

    public User(List<Integer> userAnswer) {
        this.userAnswer.addAll(userAnswer);
    }

    public List<Integer> getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(List<Integer> userAnswer) {
        this.userAnswer.addAll(userAnswer);
    }

    public User(int answer) {
        this.userAnswer = new ArrayList<>();
        while(answer > 0) {
            userAnswer.add(answer % 10);
            answer /= 10;
        }
        Collections.reverse(userAnswer);
    }
}
