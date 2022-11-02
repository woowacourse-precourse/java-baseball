package baseball.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Answer {
    private final List<Integer> answer;

    public Answer(List<Integer> answer) {
        this.answer = answer;
    }

    public static Answer of(Collection<Integer> answer) {
        return new Answer(new ArrayList<>(answer));
    }

    @Override
    public String toString() {
        return answer.toString();
    }
}
