package baseball;

import java.util.*;

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

    @Override
    public String toString() {
        return "Number{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Objects.equals(numbers, number.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
