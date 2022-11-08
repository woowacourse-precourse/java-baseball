package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static boolean checkLength(List<Integer> input) {
        return input.size() == 3;
    }

    private static boolean checkDuplication(List<Integer> input) {
        Set<Integer> set = new HashSet<>(input);
        return input.size() == set.size();
    }
}
