package baseball;

import java.util.List;

public final class Answer {

    private final List<Character> answer;

    public Answer(List<Character> answer) {
        this.answer = answer;
    }

    public boolean compare(final BaseBallNumber number) {
        return new Referee().count(answer, number.toString());
    }
}
