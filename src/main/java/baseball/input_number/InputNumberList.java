package baseball.input_number;

import java.util.Collections;
import java.util.List;

public class InputNumberList {
    private final List<InputNumber> inputNumbers;

    InputNumberList(List<InputNumber> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public List<InputNumber> inputNumbers() {
        return Collections.unmodifiableList(inputNumbers);
    }
}
