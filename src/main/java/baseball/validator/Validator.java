package baseball.validator;

import java.util.List;

/**
 * 게임에 존재하는 정답에 대한 행위를 정의한다.
 */
public interface Validator {

    void setAnswer(List<Integer> answer);

    List<Integer> getAnswer();

    boolean checkAnswer(List<Integer> input);
}
