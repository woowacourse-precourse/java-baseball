package baseball;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers createRandomNumbers() {
        return new Numbers(new ArrayList<>());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
