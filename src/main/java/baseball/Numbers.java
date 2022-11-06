package baseball;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers() {
        numbers = new ArrayList<>();
    }

    public void add(int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    public int size() {
        return numbers.size();
    }
}
