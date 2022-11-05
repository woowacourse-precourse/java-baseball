package baseball.domain.number.inputnumber;

import baseball.domain.number.SingleNumber;

import java.util.Collections;
import java.util.List;

public class InputNumbers {

    private final List<SingleNumber> inputNumbers;

    InputNumbers(List<SingleNumber> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public List<SingleNumber> inputNumbers() {
        return Collections.unmodifiableList(inputNumbers);
    }
}
