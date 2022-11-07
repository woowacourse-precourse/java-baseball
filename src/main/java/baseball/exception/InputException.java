package baseball.exception;

public class InputException {
    final int PROPER_LENGTH=3;
    final String NUMERIC="[+-]?\\d+";
    final String BLANK="";
    public boolean isProperLetter(String userInput){

        return userInput.replaceAll(NUMERIC,BLANK).equals(BLANK);
    }
    public boolean isProperLength(String userInput){
        return userInput.length()==PROPER_LENGTH;
    }

}
