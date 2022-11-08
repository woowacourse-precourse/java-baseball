package baseball.Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final int GAME_NUM_LENGTH = 3;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    public static boolean checkIsLength3(List<Integer> numbers) {
        return numbers.size() == GAME_NUM_LENGTH;
    }

    public static boolean checkIsNotDuplicateNums(List<Integer> numbers) {
        Set<Integer> checkSet = new HashSet<>();
        return numbers.stream().allMatch(checkSet::add);
    }

    public static boolean checkIsValidNums(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> (MIN_NUM <= num && num <= MAX_NUM));
    }

    public static boolean checkIsCorrectNums(List<Integer> numbers) {
        if (!checkIsLength3(numbers)) {
            return false;
        }
        if (!checkIsValidNums(numbers)) {
            return false;
        }
        if (!checkIsNotDuplicateNums(numbers)) {
            return false;
        }
        return true;
    }
}

