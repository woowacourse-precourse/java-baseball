package baseball.exception;

import java.util.regex.Pattern;

public class PlayerException {

    private static final int LENGTH_LIMIT = 3;
    private static final String NOT_NUMBER_EXCEPTION = "입력은 숫자로만 해야 합니다.";
    private static final String NOT_THREE_DIGIT_EXCEPTION = "입력은 세자리 숫자여야 합니다. ";

    public void checkException(String input){

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
        return false;
    }

    public void containsZeroException(){

    }

    public boolean containsSameNumber(String input){
        return false;
    }

    public void containsSameNumberException(){

    }
}
