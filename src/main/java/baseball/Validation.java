package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    private static boolean isRangeNumber(String number){
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i) < '1' || number.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }

    private static boolean isLengthThree(String number){
        if(number.length() != 3){
            return false;
        }
        return true;
    }

    private static boolean isNotOverlap(String number){
        Set<Character> ch = new HashSet<>();
        for(int i = 0; i < 3; i++){
            ch.add(number.charAt(i));
        }
        if(ch.size() != 3){
            return false;
        }
        return true;
    }

    public static void validate(String number){
        if(!isRangeNumber(number) || !isLengthThree(number) || !isNotOverlap(number)){
            throw new IllegalArgumentException();
        }
    }
}
