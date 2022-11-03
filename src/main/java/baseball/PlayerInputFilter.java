package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class PlayerInputFilter {
    private static final int NUMBERS_COUNT_LIMIT = 3;
    private static final String NO_NUMBER_EXCEPTION = "입력한 값이 숫자가 아닙니다.";
    private static final String NOT_THREE_DIGIT_EXCEPTION = "입력한 값은 세자리 숫자여야 합니다.";
    private static final String CONTAINS_ZERO_EXCEPTION = "입력 문자열에 0이 있으면 안됩니다.";
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
        throw new IllegalArgumentException(NOT_THREE_DIGIT_EXCEPTION);
    }

    boolean containsZero(String input){
        return input.contains("0");
    }

    void containsZeroException(){
        throw new IllegalArgumentException(CONTAINS_ZERO_EXCEPTION);
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
