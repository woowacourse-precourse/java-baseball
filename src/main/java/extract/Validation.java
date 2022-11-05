package extract;

import static java.lang.String.valueOf;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static boolean exception = false;

    //  예외 검사 기능
    public static boolean validationCheck(String userLine) {


        String onlyNumberCheck = "1234567890";

        String asterRiskPattern = "^[[0-9]₩~!@#$%^&*()-+=/.,|]*$";
        String stringPattern = "^[[0-9]abcdefghijklmnopqrstuvwxyz]*$";

        // 특수 기호, 문자열 검사
        Pattern.compile(asterRiskPattern);
        Pattern.compile(stringPattern);

        boolean asterRiskCheck = asterRiskPattern.matches(userLine);
        boolean stringCheck = stringPattern.matches(userLine);

        int inputToInteger = Integer.parseInt(userLine);

        // 세자리 범위
        if ( inputToInteger < 100 || inputToInteger > 999
                || !asterRiskCheck || !stringCheck ) {
            exception = true;
        }

        char checkDuplicateZero = userLine.charAt(0);
        char checkDuplicateOne = userLine.charAt(1);
        char checkDuplicateTwo = userLine.charAt(2);

        // 중복 검사
        if (checkDuplicateZero == checkDuplicateOne
                || checkDuplicateZero == checkDuplicateTwo
                || checkDuplicateOne == checkDuplicateTwo) {
            exception = true;
        }

        return exception;
    }
}



