package baseball;

import java.util.Arrays;
import java.util.HashSet;

public class Validate {
    public static boolean validateSameNumber(String number) {
        HashSet<String> sameNumber = new HashSet<>(Arrays.asList(number.split("")));
        if (number.length() == sameNumber.size()) {
            return true;
        }
        return false;
    }

    public static boolean validateCountNumber(String number, int count) {
        if (number.length() == count) {
            return true;
        }
        return false;
    }

    public static boolean validateRangeNumber(String number, int startInclusive, int endInclusive) {
        if (number.matches(String.format("[+-]?[%d-%d]*(\\.[%d-%d]+)?", startInclusive, endInclusive, startInclusive, endInclusive))) {
            return true;
        }
        return false;
    }
}
