package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static boolean validateInput(List<Integer> input) {
        return checkLength(input) && checkDuplication(input) && checkEachNum(input);
    }

    private static boolean checkLength(List<Integer> input) {
        return input.size() == 3;
    }

    private static boolean checkDuplication(List<Integer> input) {
        Set<Integer> set = new HashSet<>(input);
        return input.size() == set.size();
    }

    private static boolean checkEachNum(List<Integer> input) {
        for (Integer i : input) {
            if (i < 1 || i > 9) {
                return false;
            }
        }
        return true;
    }
}
