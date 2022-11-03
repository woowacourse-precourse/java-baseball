package baseball.input.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserNumberValidation {

    public static boolean isValidNumberLength(String number) {
        return number.length() == 3;
    }

    public static boolean hasEachDifferentNumbers(List<Integer> digitNumberList) {
        Set<Integer> digitNumberSet = new HashSet<>(digitNumberList);
        if (digitNumberSet.size() == digitNumberList.size())
            return Boolean.FALSE;

        return Boolean.TRUE;
    }

}
