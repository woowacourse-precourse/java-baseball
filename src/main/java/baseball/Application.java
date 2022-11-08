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

    public static String getResult(ArrayList<Integer> com, ArrayList<Integer> player){
        String result = "";
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++){
            if (Objects.equals(com.get(i), player.get(i))) strike ++;
            else if (player.contains(com.get(i))) ball ++;
        }

        if (ball > 0 && strike > 0)
            result = ball + "볼 " + strike + "스트라이크";
        else if (strike > 0)
            result = strike + "스트라이크";
        else if (ball > 0)
            result = ball + "볼";
        else
            result = "낫싱";

        return result;
    }

    public static void run(){
        ArrayList<Integer> computer = generateNum();
        String result = "";

        while (!result.equals("3스트라이크")){
            result = getResult(computer, userInput());
            System.out.println(result);
        }
        stop();
    }

    public static void stop(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String cmd = Console.readLine();
        System.out.println(cmd);
        if(cmd.equals("1")) run();
        else if(cmd.equals("2")) System.out.println("게임 종료");
        else System.out.println("Invalid input");
    }


    public static void main(String[] args) {

        run();

    }


}
