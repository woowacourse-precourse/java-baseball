package baseball.exception;

public class InputException {
    final String NUMERIC="[+-]?\\d+";
    final String BLANK="";
    public boolean isProperLetter(String userInput){

        return userInput.replaceAll(NUMERIC,BLANK).equals(BLANK);
    }
}
