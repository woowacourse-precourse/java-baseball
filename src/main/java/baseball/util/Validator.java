package baseball.util;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {
    private static final String END_SELECT = "2";
    private static final String RESTART_SELECT = "1";
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String SPLIT_STRING = "";
    private static final String NUMBER_PATTERN = "^[" +MIN_NUMER + "-" + MAX_NUMBER + "]*$";
    private static final String WRONG_NUMBER = "[ERROR} 잘못된 입력입니다.";

    public void isRightLength(String numbers){
        if(numbers.length() != NUMBER_LENGTH)
            throw new IllegalArgumentException(WRONG_NUMBER);
    }

}
