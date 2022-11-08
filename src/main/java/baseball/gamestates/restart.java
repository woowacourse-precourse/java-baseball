package baseball.gamestates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class restart {
    private static final List<Integer> RESTART = new ArrayList<>(Arrays.asList(1));

    public static boolean isRestart(List<Integer> STATE){
        if(STATE.equals(RESTART) ){
            return true;
        }
    return false;
    }
}
