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
}
