package baseball.domain;

import java.util.List;

public interface BaseBallService {

    List<Integer> selectRandomNumbers();
    void saveRandomNumbers(List<Integer> numbers);
    String inputString();
    void verify(String input);
    List<Integer> stringToIntegerList(String str);
    GameResult compareNumbers(List<Integer> numbers);
    int inputQuestionRestart();
}
