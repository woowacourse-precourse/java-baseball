package baseball.model;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Validation {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String Number_RegEx = "^[" + MIN_NUMBER + "-" + MAX_NUMBER + "]*$";

    public Validation(){}

    private boolean CheckMinToMax(String input){
        Pattern numberPattern = Pattern.compile(Number_RegEx);
        return numberPattern.matcher(input).matches();
    }

    private boolean CheckDuplicate(String input){
        return Arrays.stream(input.split(""))
                .distinct()
                .count() == input.length();
    }

}
