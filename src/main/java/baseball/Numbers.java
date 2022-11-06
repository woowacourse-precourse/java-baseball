package baseball;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers() {
        numbers = new ArrayList<>();
    }

    public void validateNumbers() {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("입력된 수가 지정 갯수 초과입니다.");
        }
        if (numbers.stream().distinct().toArray().length != 3) {
            throw new IllegalArgumentException("중복된 수가 존재합니다.");
        }
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
