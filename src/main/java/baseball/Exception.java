package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Exception {
    public boolean isCheckDigit(String inputNumber) {
        String digit ="[0-9]+";
        return Pattern.matches(digit, inputNumber);
    }

    public boolean isCheckLength(String inputNumber) {
        return inputNumber.length() == 3;
    }

    public boolean isCheckOverlap(String inputNumber) {
        String[] arr = inputNumber.split("");
        Set<String> check = new HashSet<>(Arrays.asList(arr));
        return check.size() == inputNumber.length();
    }

    public boolean isCheckRange(String inputNumber) {
        return !inputNumber.contains("0");
    }

    public boolean isValidNumber(int inputNumber) {
        return inputNumber == 1 || inputNumber == 2;
    }
}
