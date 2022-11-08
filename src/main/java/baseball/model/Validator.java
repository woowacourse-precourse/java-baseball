package baseball.model;

import java.util.List;

public class Validator {
    public void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException();
        }

        for (int num : numbers) {
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException();
            }
            if (numbers.contains(num)) {
                throw new IllegalArgumentException();
            }
        }
    }
}