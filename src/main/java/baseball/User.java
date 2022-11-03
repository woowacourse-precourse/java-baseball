package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    public static List<Integer> inputNum(List<Integer> playerNum){
        String playerNumString = Console.readLine();
        char[] playerNumCharArr = playerNumString.toCharArray();

        for(int c : playerNumCharArr){
            playerNum.add(c);
        }
        return playerNum;
    }
    public static void exception(List<Integer> playerNum){
        try{
            if(playerNum.size() == 3){
                Play.run(playerNum);
            }
        }catch (IllegalArgumentException e){
            System.out.println("숫자를 잘못 입력하셨습니다");
            Retry.printSentence();
        }
    }
}
