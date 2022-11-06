package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidCheck {
    public static void numberCheck(String inputNumber){
        for(int i = 0; i < inputNumber.length(); i++){
            if(!Character.isDigit(inputNumber.charAt(i)))
                throw new IllegalArgumentException();
        }
    }
    public static void validInputNumber(List<Integer> userInput){
        if(userInput.size() != 3){
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
    public static boolean isValidPress(String userResponse){
        if(userResponse.length() == 1) {
            if (userResponse.contains("1"))
                return true;
            if (userResponse.contains("2"))
                return false;
        }
        throw new IllegalArgumentException("1, 2 의 숫자를 입력하셨습니다");
    }
}
