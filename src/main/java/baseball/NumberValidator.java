package baseball;

import java.util.HashSet;
import java.util.Set;

public class NumberValidator {
    public static Boolean valid(Integer number) {
        String numberStringType = String.valueOf(number);
        if(numberStringType.length() != 3)
            return false;
        if (numberStringType.contains("0"))
            return false;
        if (isContainSameCharacter(numberStringType))
            return false;
        return true;
    }

    private static boolean isContainSameCharacter(String string) {
        Set<Character> set = new HashSet<>();
        for (var c : string.toCharArray()) {
            if (set.contains(c))
                return true;
            set.add(c);
        }
        return false;
    }
}
