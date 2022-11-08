package baseball.model;

import java.util.List;

public class NumberValidator {

    public static boolean checkIfIsDuplicateNum(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }
}
