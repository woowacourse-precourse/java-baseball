package baseball.domain;

import java.util.List;

public class Answer {

    private final List<Integer> numbers;

    public Answer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int get(int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
    }
}
