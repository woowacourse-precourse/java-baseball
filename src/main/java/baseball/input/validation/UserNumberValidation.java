package baseball.input.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserNumberValidation {

    public static boolean isValidNumberLength(String number) {
        return number.length() == 3;
    }

    public static boolean hasEachDifferentNumbers(String number) {
        Set<String> digitNumberSet = new HashSet<>(List.of(number.split("")));
        System.out.println(digitNumberSet.size());
        if (digitNumberSet.size() == number.length())
            return Boolean.TRUE;

        return Boolean.FALSE;
    }

}
