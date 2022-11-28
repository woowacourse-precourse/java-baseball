package baseball.model.number;

import java.util.ArrayList;
import java.util.List;

public class NumberCollection {
    private final List<Number> numbers;

    public NumberCollection(List<Integer> numbers) {
        this.numbers = setNumbers(numbers);
    }

    private List<Number> setNumbers(List<Integer> input) {
        List<Number> numbers = new ArrayList<>();
        for (int index = 0; index < input.size(); index++) {
            Number number = new Number(index, input.get(index));
            numbers.add(number);
        }
        return numbers;
    }

    public int countStrikes(NumberCollection otherObj) {
        return (int) numbers.stream()
                .filter(otherObj::hasStrikeOf)
                .count();
    }

    private boolean hasStrikeOf(Number otherNumber) {
        return numbers.stream()
                .anyMatch(number -> number.equals(otherNumber));
    }

    public int countBalls(NumberCollection otherObj) {
        return (int) numbers.stream()
                .filter(otherObj::hasBallOf)
                .count();
    }

    private boolean hasBallOf(Number otherNumber) {
        return numbers.stream()
                .anyMatch(number -> number.hasOnlyDifferentIndexWith(otherNumber));
    }
}
