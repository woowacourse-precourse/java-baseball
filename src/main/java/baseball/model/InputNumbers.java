package baseball.model;

import java.util.List;
import java.util.function.Predicate;

public class InputNumbers {
    private List<InputNumber> inputNumbers;

    public InputNumbers(List<InputNumber> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public int count(Predicate<InputNumber> predicate) {
        return (int) inputNumbers.stream()
                .filter(predicate)
                .count();
    }
}
