package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class Generator {

    public static HashMap<Character,Integer> computer;
    private static StringBuilder sb;

    //해쉬맵에 각자리의 숫자와 인덱스 위치를 저장하여 나중에 힌트를 구할 때 편리하게 사용
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
