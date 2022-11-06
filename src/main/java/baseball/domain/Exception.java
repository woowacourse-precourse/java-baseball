package baseball.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exception {
    public static final String RANGE_FORMAT_PATTERN = "(^[1-9]*$)";

    public static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력해주세요.";
    public static final String NUMBER_RANGE_ERROR_MESSAGE = "1에서 9사이의 숫자만 입력해주세요.";

    public static void throwException(String message) {
        throw new IllegalArgumentException(message);
    }

    public static void checkNumberFormatException(String number) {
        try{
            Integer.parseInt(number);
        } catch (NumberFormatException e){
            throwException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void checkNumberRangeException(String number) {
        Pattern p = Pattern.compile(RANGE_FORMAT_PATTERN);
        Matcher m = p.matcher(number);
        if(!m.matches()){
            throwException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}
