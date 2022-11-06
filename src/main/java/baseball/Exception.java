package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Exception {
    public static boolean isCheckDigit(String inputNumber) {
        String digit ="[0-9]+";
        return Pattern.matches(digit, inputNumber);
    }

    public static boolean isCheckLength(String inputNumber) {
        return inputNumber.length() == 3;
    }

    public static boolean isCheckOverlap(String inputNumber) {
        String[] arr = inputNumber.split("");
        Set<String> check = new HashSet<>(Arrays.asList(arr));
        return check.size() == inputNumber.length();
    }

    public static boolean isCheckRange(String inputNumber) {
        return !inputNumber.contains("0");
    }

    public static boolean isValidNumber(int inputNumber) {
        return inputNumber == 1 || inputNumber == 2;
    }
}
