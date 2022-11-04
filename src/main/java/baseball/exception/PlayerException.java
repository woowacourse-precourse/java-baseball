package baseball.exception;

import java.util.regex.Pattern;

public class PlayerException {

    public boolean isNotNumber(String input){
        return !Pattern.matches("^[1-9]*$", input);
    }

    public void checkException(String input){

    }

    public void noNumberException(){

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
