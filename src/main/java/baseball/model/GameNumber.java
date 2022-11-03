package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameNumber {
    private final List<Integer> answer;

    public GameNumber(Set<Integer> answer) {
        this.answer = new ArrayList<>(answer);
    }

    public boolean contains(int value) {
        return answer.contains(value);
    }

    public int get(int index) {
        return answer.get(index);
    }
}
