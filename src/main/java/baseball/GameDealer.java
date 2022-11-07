package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Pattern;


public class GameDealer {
    public static String Str_Problem_Num = "";
    public static String GEN_PROBLEM(){
        String result = "";

        while(result.length() < 3){
            String tmp =  String.valueOf(Randoms.pickNumberInRange(1, 9));
            if(!result.contains(tmp)){
                result += tmp;
            }
        }
        return result;
    }
    public static boolean ONE_GAME_LOOP() throws IllegalArgumentException{
        boolean result = true;
        boolean Check_Ans = false;
        while(!Check_Ans){
            PRINT_PROMPT();
            String User_Try = Console.readLine();
            System.out.println(User_Try);
            if(!CHECK_VALID_INPUT(User_Try)){
                throw new IllegalArgumentException();
            }
            Check_Ans = CHECK_AND_PRINT_INFO(User_Try);
            if(Check_Ans){
                PRINT_GAME_CLEAR_MSG();
                result = CHECK_GAME_RETRY();
            }

        }
        return result;
    }
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
