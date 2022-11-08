package baseball.domain;

import baseball.util.Constant;
import baseball.util.Utilization;
import baseball.util.Validation;

import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer() {}

    public void generateNumbers() {
        numbers = Utilization.pickRandomNumberList();
        while (!Validation.validateNumberNotRepeated(numbers, Constant.NUMBER_LENGTH)) {
            numbers = Utilization.pickRandomNumberList();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
