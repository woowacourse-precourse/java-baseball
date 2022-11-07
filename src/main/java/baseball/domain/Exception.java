package baseball.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exception {
    public static final String RANGE_FORMAT_PATTERN = "(^[1-9]*$)";
    public static final String REPEATED_PATTERN = "(.)\\1+";
    public static final int CORRECT_LENGTH = 3;
    public static final String RESTART = "1";
    public static final String QUIT = "2";

    public static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력해주세요.";
    public static final String NUMBER_RANGE_ERROR_MESSAGE = "1에서 9사이의 숫자만 입력해주세요.";
    public static final String NUMBER_LENGTH_ERROR_MESSAGE = "올바른 길이의 숫자를 입력해주세요.";
    public static final String REPEATED_NUMBER_ERROR_MESSAGE = "서로 다른 숫자를 입력해주세요.";
    public static final String CHOICE_ERROR_MESSAGE = "1 또는 2를 입력해주세요.";

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

    public static void checkNumberLengthException(String number) {
        if(number.length() != CORRECT_LENGTH){
            throwException(NUMBER_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void checkRepeatedNumberException(String number) {
        Pattern p = Pattern.compile(REPEATED_PATTERN);
        Matcher m = p.matcher(number);
        if(m.find()){
            throwException(REPEATED_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void checkChoiceException(String choice) {
        if(!(choice.equals(RESTART) || choice.equals(QUIT))) {
            throwException(CHOICE_ERROR_MESSAGE);
        }
    }
}
