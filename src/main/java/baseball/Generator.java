package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;



public class Generator {

    private static HashMap<Character,Boolean> overlapCheck;
    private static String computer;
    private static StringBuilder sb;

    public String Generator(){

        overlapCheck = new HashMap<>();
        sb = new StringBuilder();
        computer=RandomGenerator(sb);

        return computer;
    }

    public static String RandomGenerator(StringBuilder sb){
         while(sb.length()<3) {
             char randomNumber = (char)(Randoms.pickNumberInRange(1, 9)+'0');
             if(IsException(randomNumber)){
                 continue;
             }
             else{
                 sb.append(randomNumber);
             }

         }
         return computer;
    }

    public static boolean IsException(char number){
        if(overlapCheck.containsKey(number))return true;
        else overlapCheck.put(number,true);
        return false;
    }
}
