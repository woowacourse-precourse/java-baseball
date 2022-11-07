package baseball.model;

import java.util.List;

public abstract class Gamer {
    static final int NUMBER_SIZE = 3;

    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
