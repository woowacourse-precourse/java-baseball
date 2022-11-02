package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
public class Application {
    public static ArrayList<Integer> GenerateNum(){ // 숫자 생성
        ArrayList<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public static ArrayList<Integer> InputNum(){
        String playerNumString = Console.readLine();
        if (InvalidInput(playerNumString)) throw new IllegalArgumentException("Invalid input");
        char[] playerNumArray = playerNumString.toCharArray();
        ArrayList<Integer> playerNum = new ArrayList<>();
        for(char num : playerNumArray){
            playerNum.add(num - '0');
        }
        return playerNum;
    }

    public static boolean InvalidInput(String num){
        return num.length() != 3;
    }
    public static void main(String[] args) {
//        List<Integer> answer = GenerateNum();
        System.out.println(InputNum());

        // TODO: 프로그램 구현
    }
}
