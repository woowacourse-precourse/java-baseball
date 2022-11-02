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
        char[] playerNumString = Console.readLine().toCharArray();
        ArrayList<Integer> playerNum = new ArrayList<Integer>();
        for(char num : playerNumString){
            playerNum.add(num - '0');
        }
        return playerNum;
    }
    public static void main(String[] args) {
//        List<Integer> answer = GenerateNum();
        System.out.println(InputNum());

        // TODO: 프로그램 구현
    }
}
