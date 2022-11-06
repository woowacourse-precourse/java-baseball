package baseball;

import java.util.List;

public class Answer {

    private static List<Character> answer;

    public Answer(List<Character> answer) {
        Answer.answer = answer;
    }

    public boolean compare(BaseBallNumber number) {
      return new Count().count(answer, number.toString());
    }
}
