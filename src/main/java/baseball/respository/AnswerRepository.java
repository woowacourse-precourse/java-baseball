package baseball.respository;

import java.util.ArrayList;
import java.util.List;

public class AnswerRepository {
    private static AnswerRepository instance;
    private List<Integer> correctAnswer;

    private AnswerRepository() {
    }

    public static AnswerRepository getInstance() {
        if (instance == null) {
            instance = new AnswerRepository();
        }
        return instance;
    }

    public void save(List<Integer> correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<Integer> getCorrectAnswer() {
        return correctAnswer;
    }
}
