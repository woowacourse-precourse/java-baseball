package baseball;

import java.util.List;

public class Answer {

    private final List<Character> answer;

    public Answer(List<Character> answer) {
        this.answer = answer;
    }

    public boolean compare(final BaseBallNumber number) {
      return new Count().count(answer, number.toString());
    }
}
