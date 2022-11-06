package baseball.domain;

import java.util.List;

public interface BaseBallService {

    void selectRandomNumbers();
    void saveRandomNumbers();
    void inputNumbers();
    void compareNumbers(List<Integer> numbers);
    int inputQuestionRestart();
}
