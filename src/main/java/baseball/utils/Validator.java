package baseball.utils;

import java.util.regex.Pattern;

public class Validator {
    public static void checkUserAnswerInput(String userAnswer) {
        checkStringLength(userAnswer, 3);
        checkNumber(userAnswer);
    }

    private static void checkStringLength(String string, int length) {
        if(string.length() != length) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNumber(String string) {
        boolean isNumber = Pattern.matches("^[0-9]*$", string);
        if(!isNumber){
            throw new IllegalArgumentException();
        }
    }
}
