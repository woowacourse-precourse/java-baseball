package baseball.exceptions.standards;

import java.util.List;

public class sizeover {

    public static boolean sizeover(List<Integer> number){
        if(number.size() != 3){
            return true;
        }
        return false;
    }
}
