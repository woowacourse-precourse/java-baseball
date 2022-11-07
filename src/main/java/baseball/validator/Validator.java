package baseball.validator;

import java.util.List;

public interface Validator {
    void setAnswer(List<Integer> answer);
    List<Integer> getAnswer();
    boolean checkAnswer(List<Integer> input);
}
