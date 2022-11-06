package baseball;

import java.lang.reflect.Array;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    // TODO: 코드 구현
    public static ArrayList<Integer> generateNum(){
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static ArrayList<Integer> userInput(){
        String user_num = Console.readLine();
        if(checkVal(user_num)) throw new IllegalArgumentException("Invalid input");

        char[] playerNumArray = user_num.toCharArray();
        ArrayList<Integer> playerNum = new ArrayList<>();

        for(char num : playerNumArray){
            playerNum.add(num - '0');
        }
        
        return playerNum;
    }

    public static boolean checkVal(String num){
        return num.length() != 3;
    }



    public static void run(){
        ArrayList<Integer> computer = generateNum();
        ArrayList<Integer> player = userInput();

        System.out.println(computer);
        System.out.println(player);

//        System.out.println(getResult(computer, player));
    }


    public static void main(String[] args) {

        run();

    }


}
