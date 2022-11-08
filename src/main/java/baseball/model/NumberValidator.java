package baseball.model;

import java.util.List;

public class NumberValidator {

    public static boolean checkIfIsNotDuplicatedNum(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }

    public static boolean isNumberExistInList(Integer integer, List<Integer> computerNum) {
        return false;
    }
}
