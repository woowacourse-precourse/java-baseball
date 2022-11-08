package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

import static baseball.utils.ExceptionMessage.*;

public class InputView {
    private final static int VALID_SIZE = 3;
    private final static String RE_START = "1";
    private final static String END = "2";
    private final static String PATTERN = "^[0-9]{3}$";

    public String requestInput(){
        String userInput = Console.readLine();
        if (validateUserInputIsNumber(userInput) && validateUserInputIsDuplicated(userInput)){
            return userInput;
        }
        return "";
    }

    public String questionInput(){
        String userInput = Console.readLine();
        if(validateUserInputIsStartOrEnd(userInput)){
            return userInput;
        }
        return "";
    }

    private boolean validateUserInputIsNumber(String userInput){
        if (Pattern.matches(PATTERN,userInput)){
            return true;
        }
        throw new IllegalArgumentException(USER_INPUT_NON_NUMBER_EXCEPTION);
    }

    private boolean validateUserInputIsDuplicated(String userInput){
        HashSet<String> userInputSet = new HashSet<>(List.of(userInput.split("")));
        if(userInputSet.size() == VALID_SIZE){
            return true;
        }
        throw new IllegalArgumentException(USER_INPUT_DUPLICATED_NUMBER_EXCEPTION);
    }

    private boolean validateUserInputIsStartOrEnd(String userInput){
        if (userInput.equals(RE_START) || userInput.equals(END)){
            return true;
        }
        throw new IllegalArgumentException(USER_INPUT_END_EXCEPTION);
    }
}
