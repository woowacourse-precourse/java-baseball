package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.Constant.*;
public class CheckUtil {

    public void checkIsValidDigit(String input){
        for(char c:input.toCharArray()){
            int c_int = Character.getNumericValue(c);
            if(c_int<1 || c_int>9){
                throw new IllegalArgumentException(invalidNumberMessage);
            }
        }
    }

    public void checkIsValidLength(int length){
        if(length != 3){
            throw new IllegalArgumentException(invalidLengthMessage);
        }
    }

    public void checkIsDuplicated(List<String> userNumList){
        Map<String,Integer> map = new HashMap<>();
        for(String userNum:userNumList){
            map.put(userNum,map.getOrDefault(userNum,0)+1);
        }
        for(String str: map.keySet()){
            if(map.get(str)>1){
                throw new IllegalArgumentException(duplicatedNumberMessage);
            }
        }
    }
}
