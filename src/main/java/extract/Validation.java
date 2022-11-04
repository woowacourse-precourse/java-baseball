package features;

import static java.lang.String.valueOf;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    private static boolean exception = false;

    //  예외 검사 기능
    public static boolean validationCheck(int threeDigitsNumber) {
        String numberToString = valueOf(threeDigitsNumber);

        for (int i = 0; i < numberToString.length(); i++) {
            char checkDuplicateZero = numberToString.charAt(0);
            char checkDuplicateOne = numberToString.charAt(1);
            char checkDuplicateTwo = numberToString.charAt(2);

            // 중복 검사
            if (checkDuplicateZero == checkDuplicateOne
                    || checkDuplicateOne == checkDuplicateTwo
                    || checkDuplicateZero == checkDuplicateTwo) {
                exception = true;
            }
        }

        // 특수 기호
        String onlyNumberCheck = "^[[0-9]$@$!%*#?&]*$";
        Pattern compile = Pattern.compile(onlyNumberCheck);
        boolean matches = onlyNumberCheck.matches(numberToString);

        // 세자리 범위
        if (threeDigitsNumber < 100 || threeDigitsNumber > 999 || !matches) {
            exception = true;
        }

        return exception;
    }
}



