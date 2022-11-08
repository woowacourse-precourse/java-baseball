package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidCheck {
    public static final int PROPER_SIZE = 3;
    public static final int PROPER_LENGTH = 1;
    public static final String CONTINUE_BUTTON = "1";
    public static final String END_BUTTON = "2";
    public static void numberCheck(String inputNumber){
        for(int i = 0; i < inputNumber.length(); i++){
            if(!Character.isDigit(inputNumber.charAt(i)))
                throw new IllegalArgumentException("숫자를 입력하세요!");
        }
    }
    public static void validInputNumber(List<Integer> userInput){
        if(userInput.size() != PROPER_SIZE){
            throw new IllegalArgumentException("3자리 숫자를 입력하십시오");
        }
        if(userInput.contains(0)){
            throw new IllegalArgumentException("0은 포함 되면 안됩니다");
        }
        Set<Integer> checkOverlapNumber = new HashSet<>(userInput);
        if(checkOverlapNumber.size() != userInput.size()){
            throw new IllegalArgumentException("중복된 숫자가 있습니다");
        }
    }
    public static boolean isContinueGame(String userResponse){
        if(userResponse.length() == PROPER_LENGTH) {
            if (userResponse.contains(CONTINUE_BUTTON))
                return true;
            if (userResponse.contains(END_BUTTON))
                return false;
        }
        throw new IllegalArgumentException("올바른 입력을 부탁드립니다");
    }
}
