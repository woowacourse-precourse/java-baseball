package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    public List<Integer> numbers = new ArrayList<>();

    public Numbers(List<Integer> numbers) {
        validateNumbersDuplicate(numbers);
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
}
