package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static boolean createComputerNum(List<Integer> computer){
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        if(computer.size() == 3)
            return true;
        else
            return false;
    }

    public static List<Integer> inputPlayerNum(){
        List<Integer> player = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String playerNum = Console.readLine();

        for (int i = 0; i < playerNum.length(); i++) {
            player.add(playerNum.charAt(i)-'0');
        }
        return player;
    }
}
