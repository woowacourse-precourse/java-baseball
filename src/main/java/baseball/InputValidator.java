package baseball;

import java.util.HashSet;
import java.util.regex.Pattern;

public class InputValidator {
    public static boolean isValidNumbers(int input) {
        String pattern = "[1-9]{3}";
        String inputString = String.valueOf(input);
        boolean result = Pattern.matches(pattern, inputString);
        return result;
    }

    public static boolean hasDuplicatedNumber(int input) {
        // 중복된 값이 있을 경우 True 반환
        int[] digits = Integer.toString(input).chars().map(c -> c-'0').toArray();
        HashSet tempSet = new HashSet();
        for (Integer integer : digits)
            if (!tempSet.add(integer)) {
                return false;
            }
        return true ;
    }
}
