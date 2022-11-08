package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException();
        }

        Set<Integer> set = new HashSet<>();
        for (int num : numbers) {
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException();
            }
            if (set.contains(num)) {
                throw new IllegalArgumentException();
            }
            set.add(num);
        }
    }
}