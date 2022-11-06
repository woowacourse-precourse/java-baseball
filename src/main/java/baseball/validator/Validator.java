package baseball.validator;

import java.util.List;

public interface Validator {
    void setAnswer(List<Integer> answer);
    boolean checkAnswer(List<Integer> input);
    void validateAnswer(List<Integer> input);
}
