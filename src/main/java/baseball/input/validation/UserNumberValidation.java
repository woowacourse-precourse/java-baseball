package baseball.input.validation;

import java.util.HashSet;
import java.util.Set;

public class UserNumberValidation {

    public static boolean isValidNumberLength(String number) {
        return number.length() == 3;
    }

    public static boolean hasEachDifferentNumbers(String number) {
        Set<String> digitNumberSet = new HashSet<>();
        digitNumberSet.add(number);

        if (digitNumberSet.size() == number.length())
            return Boolean.FALSE;

        return Boolean.TRUE;
    }

}
