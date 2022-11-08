package baseball.view;

import java.util.HashSet;
import java.util.Set;

public class BaseballGameInputValidator {
    public static boolean validatePlayerNumber(String input) {
        Set<Integer> set = new HashSet<>();
        if (input.length() != 3) {
            return false;
        }
        if (input.chars().anyMatch(c -> !set.add(c) || !Character.isDigit(c))) {
            return false;
        }
        return true;
    }

    public static boolean validateReplayNumber(String input) {
        if (input.equals("1") || input.equals("2")) {
            return true;
        }
        return false;
    }
}
