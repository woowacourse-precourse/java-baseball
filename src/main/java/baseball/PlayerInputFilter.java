package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class PlayerInputFilter {
    private int[] numbers;

    public PlayerInputFilter(){
        numbers = new int[3];
    }

    String getInput(){
        return Console.readLine();
    }

    void checkException(String input){

    }

    boolean isNotNumber(String input){
        return !Pattern.matches("^[1-9]*$", input);
    }

    void noNumberException(){

    }

    boolean isNotThreeDigit(String input){
        return false;
    }

    void notThreeDigitException(){

    }

    boolean containsZero(String input){
        return false;
    }

    void containsZeroException(){

    }

    boolean containsSameNumber(String input){
        return false;
    }

    void containsSameNumberException(){

    }

    int[] convertNumbersToArray(String input){
        return new int[]{};
    }

    void insertNumber(){

    }
}
