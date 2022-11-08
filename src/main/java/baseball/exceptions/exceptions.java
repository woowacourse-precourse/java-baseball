package baseball.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.exceptions.standards.samething.isSame;
import static baseball.exceptions.standards.sizeover.sizeover;


public class exceptions {


    public static boolean exception(List<Integer> number){
        if(sizeover(number)){
            throw new IllegalArgumentException("fail : argument check please. ('Three' Different Numbers)");
        }
        if(isSame(number)){
            throw new IllegalArgumentException("fail : argument check please. (Three 'Different' Numbers)");
        }
        return false;
    }

}
