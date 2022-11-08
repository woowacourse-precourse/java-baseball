package baseball.model.computer;

import baseball.model.player.BaseBallNumber;
import java.util.ArrayList;
import java.util.List;

public final class Answer {

    private final List<Character> answer;

    public Answer(List<Character> answer) {
        this.answer = new ArrayList<>(answer);
    }

    public boolean compare(final BaseBallNumber number) {
        return new Referee().count(answer, number.toString());
    }
}
