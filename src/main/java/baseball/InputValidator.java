package baseball;

import java.util.HashSet;
import java.util.regex.Pattern;

public class InputValidator {
    public static boolean isValidInput(String input) {
        return InputValidator.isValidNumbers(input) && InputValidator.hasDuplicatedNumber(input);
    }
    public static boolean isValidNumbers(String input) {
        String pattern = "[1-9]{3}";
        return Pattern.matches(pattern, input);
    }

    public static boolean hasDuplicatedNumber(String input) {
        // 중복된 값이 있을 경우 false 반환
        int[] digits = input.chars().map(c -> c-'0').toArray();
        HashSet tempSet = new HashSet();
        for (Integer integer : digits)
            if (!tempSet.add(integer)) {
                return false;
            }
        return true;
    }
}
