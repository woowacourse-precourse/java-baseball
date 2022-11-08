package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class Generator {

    public static HashMap<Character,Integer> computer;
    private static StringBuilder sb;

    public HashMap<Character,Integer> Generator(){

        computer = new HashMap<>();
        sb = new StringBuilder();
        RandomGenerator(sb);

        return computer;
    }

    public static void RandomGenerator(StringBuilder sb){
         while(sb.length()<3) {
             char randomNumber = (char)(Randoms.pickNumberInRange(1, 9)+'0');
             if(IsException(randomNumber,sb.length())){
                 continue;
             }
             else{
                 sb.append(randomNumber);
             }
         }
    }

    public static boolean IsException(char number,int index){
        if(computer.containsKey(number))return true;
        else computer.put(number,index);
        return false;
    }
}
