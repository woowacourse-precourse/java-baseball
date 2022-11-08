package baseball.checker;

import static baseball.utility.Utility.*;
import java.util.*;

public class Checker {
    public static boolean IsDigit(char ch){
        return ch >= '1' && ch <= '9';
    }
    public static boolean IsInvalidInput(String user){
        if(user.length() != ANSWER_LENGTH) {
            return true;
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<user.length(); i++){
            if(!IsDigit(user.charAt(i))){
                return true;
            }
            Integer temp = user.charAt(i) - '0';
            set.add(temp);
        }

        return set.size() == 3;
    }

}
