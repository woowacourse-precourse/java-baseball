package baseball;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static boolean exception = false;


    //  예외 검사 기능
    public static boolean validationCheck(String validation) {

        // 숫자 외 정보 입력 (특수 기호, 문자열)
        patternCheck(validation);

        // 중복 검사
        duplicateCheck(validation);

        // 범위를 벗어난 수 검사
        rangeCheck(validation);

        return exception;

    }

    private static void patternCheck(String validation) {

        String asterRiskExpression = "^[₩~!@#$%^&*()-+=/.,|]*$";
        String stringExpression = "^[abcdefghijklmnopqrstuvwxyz]*$";

        Pattern compileAsterRisk = Pattern.compile(asterRiskExpression);
        Pattern compileString = Pattern.compile(stringExpression);

        Matcher asterRiskCheck = compileAsterRisk.matcher(validation);
        Matcher stringCheck = compileString.matcher(validation);

        if ( asterRiskCheck.find() || stringCheck.find() ) {
            throw new IllegalArgumentException("서로 다른 수로 이루어진 세자리 수를 입력해주세요.");
        }
    }


    private static void rangeCheck(String validation)  {
        if (Integer.parseInt(validation) < 100 || Integer.parseInt(validation) > 999) {
            throw new IllegalArgumentException("서로 다른 수로 이루어진 세자리 수를 입력해주세요.");
        }
    }

    private static void duplicateCheck(String validation) {

        char checkDuplicateZero = validation.charAt(0);
        char checkDuplicateOne = validation.charAt(1);
        char checkDuplicateTwo = validation.charAt(2);

        // 중복 검사
        if (checkDuplicateZero == checkDuplicateOne
                || checkDuplicateZero == checkDuplicateTwo
                || checkDuplicateOne == checkDuplicateTwo) {
            throw new IllegalArgumentException("서로 다른 수로 이루어진 세자리 수를 입력해주세요.");
        }
    }

}



