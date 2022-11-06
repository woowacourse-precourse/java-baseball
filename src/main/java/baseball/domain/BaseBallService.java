package baseball.domain;

import java.util.List;

public interface BaseBallService {

    List<Integer> selectRandomNumbers();
    void saveRandomNumbers(List<Integer> numbers);
    void inputNumbers();
    void compareNumbers(List<Integer> numbers);
    int inputQuestionRestart();
}
