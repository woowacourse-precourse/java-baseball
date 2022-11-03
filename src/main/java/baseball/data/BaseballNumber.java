package baseball.data;

import baseball.util.Validator;

import java.util.List;

public class BaseballNumber {

    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void updateNumbers(List<Integer> updateNumbers) {
        numbers = updateNumbers;
        Validator.isValidNumber(numbers);
    }
}
