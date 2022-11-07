package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

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
