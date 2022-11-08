package baseball.gamestates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class stop {
    private static final List<Integer> STOP = new ArrayList<>(Arrays.asList(2));

    public static boolean isStop(List<Integer> STATE){
        if(STATE.equals(STOP)){
            return true;
        }
        return false;
    }

}
