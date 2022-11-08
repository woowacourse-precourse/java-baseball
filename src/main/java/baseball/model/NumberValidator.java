package baseball.model;

import java.util.List;

public class NumberValidator {

    public static boolean checkIfIsNotDuplicatedNum(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }
}
