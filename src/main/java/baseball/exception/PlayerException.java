package baseball.exception;

import java.util.regex.Pattern;

public class PlayerException {

    private static final int LENGTH_LIMIT = 3;
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    private static final String NOT_NUMBER_EXCEPTION = "입력은 숫자로만 해야 합니다.";
    private static final String NOT_THREE_DIGIT_EXCEPTION = "입력은 세자리 숫자여야 합니다. ";
    private static final String NO_ZERO_EXCEPTION = "입력한 값에 0이 없어야 합니다.";
    private static final String SAME_NUMBER_EXCEPTION = "입력한 값이 서로 다른 숫자여야 합니다. ";

    public void checkException(String input){
        if(isNotNumber(input)) noNumberException();
        if(isNotThreeDigit(input)) notThreeDigitException();
        if(containsZero(input)) containsZeroException();
        if(containsSameNumber(input)) containsSameNumberException();
    }

    public boolean isNotNumber(String input){
        return !Pattern.matches("^[1-9]*$", input);
    }

    public void noNumberException(){
        throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
    }

    public boolean isNotThreeDigit(String input){
        return input.length() != LENGTH_LIMIT;
    }

    public void notThreeDigitException(){
        throw new IllegalArgumentException(NOT_THREE_DIGIT_EXCEPTION);
    }
    public boolean containsZero(String input){
        return input.contains("0");
    }

    public void containsZeroException(){
        throw new IllegalArgumentException(NO_ZERO_EXCEPTION);
    }

    public boolean containsSameNumber(String input){
        return input.charAt(FIRST) == input.charAt(SECOND)
                || input.charAt(SECOND) == input.charAt(THIRD)
                || input.charAt(THIRD) == input.charAt(FIRST);
    }

    public void containsSameNumberException(){
        throw new IllegalArgumentException(SAME_NUMBER_EXCEPTION);
    }
}
