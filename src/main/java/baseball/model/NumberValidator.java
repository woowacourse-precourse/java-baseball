package baseball.model;

import java.util.List;

public class NumberValidator {

    public static boolean checkIfIsNotDuplicatedNum(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }

    public static boolean isNumberExistInList(Integer number, List<Integer> computerNum) {
        return computerNum.contains(number);
    }
}
