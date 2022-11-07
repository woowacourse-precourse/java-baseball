package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private static final int REGULAR_NUMBERS_SIZE = 3;
    public List<Integer> numbers = new ArrayList<>();

    public Numbers(List<Integer> numbers) {
        validateNumbersDuplicate(numbers);
        validateNumbersSize(numbers);
        this.numbers = numbers;
    }

    private static void validateNumbersDuplicate(List<Integer> numbers) {
        List<Integer> cachedNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (cachedNumbers.contains(number)) {
                throw new IllegalArgumentException("숫자는 중복될 수 없습니다");
            }
            cachedNumbers.add(number);
        }
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() < REGULAR_NUMBERS_SIZE || numbers.size() > REGULAR_NUMBERS_SIZE) {
            throw new IllegalArgumentException("숫자는 3개만 입력 가능합니다");
        }
    }
}
