package baseball.rulls;

import java.util.List;

public class ball {

    public static boolean isBall(List<Integer> computerList , int userNumber){
        if(computerList.contains(userNumber)){
            return true;
        }
        return false;
    }
}
