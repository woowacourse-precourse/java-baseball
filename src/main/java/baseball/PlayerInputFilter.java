package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class PlayerInputFilter {
    private static final int NUMBERS_COUNT_LIMIT = 3;
    private static final String NO_NUMBER_EXCEPTION = "입력한 값이 숫자가 아닙니다.";
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
        throw new IllegalArgumentException(NO_NUMBER_EXCEPTION);
    }

    boolean isNotThreeDigit(String input){
        return NUMBERS_COUNT_LIMIT != input.length();
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
