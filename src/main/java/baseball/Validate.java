package baseball;

import java.util.HashSet;
import java.util.Set;
import static baseball.Constants.*;
public class Validate {
    public static void validateInputNumber(String input){
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<input.length();i++){
            char cur = input.charAt(i);
            if(!Character.isDigit(cur)){
                throw new IllegalArgumentException();
            }
            if(cur == '0'){
                throw new IllegalArgumentException();
            }
            set.add(cur-'0');
        }
        if(set.size()!=INPUT_SIZE){
            throw new IllegalArgumentException();
        }
    }

}
