package baseball.exception;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;
public class InputException {
    private static final String ZERO="0";
    private static final int PROPER_LENGTH=3;
    private static final String NUMERIC="[+-]?\\d+";
    private static final String BLANK="";
    private static final String ERROR_MESSAGE="잘못된 값을 입력하셨습니다. 프로그램을 종료합니다.";
    public static boolean containZero(String userInput){
        return userInput.contains(ZERO);
    }
    public static boolean isNotProperLetter(String userInput){
        return !userInput.replaceAll(NUMERIC,BLANK).equals(BLANK);
    }
    public static boolean isNotProperLength(String userInput){
        return userInput.length()!=PROPER_LENGTH;
    }
    public static boolean isDuplicate(String userInput){
        List<String> separatedInput = new ArrayList<>(Arrays.asList(userInput.split("")));
        Set<String> uniqueNumber = new HashSet<>(separatedInput);
        return uniqueNumber.size()!=PROPER_LENGTH;
    }
    public static void isWrongUserInput(String userInput){
        if((containZero(userInput))||(isNotProperLetter(userInput))||(isNotProperLength(userInput))||(isDuplicate(userInput))){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
