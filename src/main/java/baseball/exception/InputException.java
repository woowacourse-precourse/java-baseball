package baseball.exception;

public class InputException {
    private static final String ZERO="0";
    private static final int PROPER_LENGTH=3;
    private static final String NUMERIC="[+-]?\\d+";
    private static final String BLANK="";
    boolean containZero(String userInput){
        return userInput.contains(ZERO);
    }
    public boolean isProperLetter(String userInput){

        return userInput.replaceAll(NUMERIC,BLANK).equals(BLANK);
    }
    public boolean isProperLength(String userInput){
        return userInput.length()==PROPER_LENGTH;
    }

}
