package baseball.exception;

import java.util.regex.Pattern;

public class PlayerException {

    private static final String NOT_NUMBER_EXCEPTION = "입력은 숫자로만 해야 합니다.";

    public boolean isNotNumber(String input){
        return !Pattern.matches("^[1-9]*$", input);
    }

    public void checkException(String input){

    }

    public void noNumberException(){
        throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
    }

    public boolean isNotThreeDigit(String input){
        return false;
    }

    public void notThreeDigitException(){
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
