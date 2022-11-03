package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static List<Integer> inputNum(){
        String playerNumString = Console.readLine();
        int[] parseInt = new int[3];
        List<Integer> playerNum = new ArrayList<Integer>();

        for(int i = 0; i < 3; i++){
            parseInt[i] = playerNumString.charAt(i) - '0';
            playerNum.add(parseInt[i]);
        }
        return playerNum;
    }

//    public static void exception(List<Integer> playerNum, List<Integer> computer){
//        playerNum = inputNum();
//
//        try{
//            if(playerNum.size() == 3){
//                Playing.compare(playerNum, computer);
//            }
//        }catch (IllegalArgumentException e){
//            System.out.println("숫자를 잘못 입력하셨습니다");
//            Retry.printSentence();
//        }
//    }
}
