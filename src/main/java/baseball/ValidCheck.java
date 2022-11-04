package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidCheck {

    public static void validInputNumber(List<Integer> userInput){
        if(userInput.size() != 3){
            throw new IllegalArgumentException();
        }
        if(userInput.contains(0)){
            throw new IllegalArgumentException();
        }
        Set<Integer> checkOverlapNum = new HashSet<>(userInput);
        if(checkOverlapNum.size() != userInput.size()){
            throw new IllegalArgumentException();
        }
    }
}
