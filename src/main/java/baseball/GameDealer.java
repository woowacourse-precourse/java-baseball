package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Pattern;


public class GameDealer {
    public static boolean ONE_GAME(String[] args) throws IllegalArgumentException{
        boolean result = true;
        Str_Problem_Num = GEN_PROBLEM();
        PRINT_START_MSG();

        try {
            result = ONE_GAME_LOOP();
        } catch (Exception e){
//            System.out.println(e);
            result = false;
            throw new IllegalArgumentException();
        }
        return result;
    }
}
