package baseball.number.inputnumber;

import java.util.Collections;
import java.util.List;

public class InputNumber {

    private final List<Integer> inputNumbers;

    InputNumber(List<Integer> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public List<Integer> inputNumbers() {
        return Collections.unmodifiableList(inputNumbers);
    }
}
