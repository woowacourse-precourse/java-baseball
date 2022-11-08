package baseball.model;

import java.util.Arrays;

public class Validation {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public Validation(){}

    private boolean CheckDuplicate(String input){
        return Arrays.stream(input.split(""))
                .distinct()
                .count() == input.length();
    }

}
