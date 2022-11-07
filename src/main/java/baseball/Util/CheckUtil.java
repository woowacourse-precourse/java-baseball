package baseball.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckUtil {
    public static void lengthCheck(String input) {
        if (input.length() != Constant.MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDuplicate(String input) {
        String[] splitInput = input.split("");
        Set<String> inputSet = new HashSet<>(Arrays.asList(splitInput));
        if (splitInput.length != inputSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isInteger(String input) {
        String regex = "[0-9]+";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}
