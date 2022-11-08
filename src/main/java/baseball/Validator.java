package baseball;

import java.util.List;

public class Validator {

    private static boolean checkLength(List<Integer> input) {
        return input.size() == 3;
    }
}
