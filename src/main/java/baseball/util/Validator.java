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

    public void isValidator(String numbers){
        isRightLength(numbers);
        isRightNumber(numbers);
        isNotOverLap(numbers);
    }

    public void isRightLength(String numbers){
        if(numbers.length() != NUMBER_LENGTH)
            throw new IllegalArgumentException(WRONG_NUMBER);
    }

    public void isNotOverLap(String numbers) {
        int size = Arrays.stream(numbers.split(SPLIT_STRING)).
                collect(Collectors.toSet()).size();

        if(size != NUMBER_LENGTH)
            throw new IllegalArgumentException(WRONG_NUMBER);
    }

    public void isRightNumber(String numbers) {
        if(!Pattern.matches(NUMBER_PATTERN,numbers))
            throw new IllegalArgumentException(WRONG_NUMBER);
    }

    public void isRightSelect(String select){
        if(!(select.equals(RESTART_SELECT) || select.equals(END_SELECT)))
            throw new IllegalArgumentException(WRONG_NUMBER);
    }
}
