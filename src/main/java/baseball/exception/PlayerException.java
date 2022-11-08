package baseball.exception;

import java.util.regex.Pattern;

public class PlayerException {

    private static final int LENGTH_LIMIT = 3;
    private static final int FIRST = 0;
    private static final int SECOND = 1;
    private static final int THIRD = 2;
    private static final String WRONG_NUMBER_EXCEPTION = "입력은 1부터 9중 서로 다른 3개의 숫자여야 합니다.";

    public void checkException(String input){
        if(isNotNumber(input) || isNotThreeDigit(input)
                || containsZero(input) || containsSameNumber(input)){
            wrongNumberException();
        }
    }

    private boolean isNotNumber(String input){
        return !Pattern.matches("^[1-9]*$", input);
    }

    private void wrongNumberException(){
        throw new IllegalArgumentException(WRONG_NUMBER_EXCEPTION);
    }

    private boolean isNotThreeDigit(String input){
        return input.length() != LENGTH_LIMIT;
    }
    private boolean containsZero(String input){
        return input.contains("0");
    }

    private boolean containsSameNumber(String input){
        return input.charAt(FIRST) == input.charAt(SECOND)
                || input.charAt(SECOND) == input.charAt(THIRD)
                || input.charAt(THIRD) == input.charAt(FIRST);
    }
}
