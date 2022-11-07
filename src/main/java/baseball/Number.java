package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Number {
    private List<Integer> numbers = new ArrayList<>();

    public Number(String line) {
        for (int i = 0; i < line.length(); i++) {
            numbers.add(Character.getNumericValue(line.charAt(i)));
        }
    }

    public Number(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int size() {
        return numbers.size();
    }

    public int get(int i) {
        return numbers.get(i);
    }

    public boolean contains(int i) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.contains(i);
    }
}
