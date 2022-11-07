package baseball.domain;

import baseball.util.Validator;
import java.util.ArrayList;
import java.util.List;

public class Numbers {
    public List<Integer> numbers = new ArrayList<>();

    public Numbers(List<Integer> numbers) {
        Validator.validateNumbersDuplicate(numbers);
        Validator.validateNumbersSize(numbers);
        this.numbers = numbers;
    }
}
