package baseball;

import static baseball.Constant.GAMEPLAY_SIZE;

public class Util {
    public static void isWeirdSize(String input_Number){
        if(input_Number.length() != GAMEPLAY_SIZE){
            throw new IllegalArgumentException();
        }
    }
}
