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

    public static boolean isValidLength(int playerNumLength){
        if(playerNumLength != 3)
            return false;
        else
            return true;
    }

    public static boolean isExistDuplicate(List<Integer> player){
        int hundreds = player.get(0);
        int tens = player.get(1);
        int units = player.get(2);

        if(hundreds == tens || hundreds == units || tens == units)
            return true;
        else
            return false;
    }

    public static boolean checkValidPlayerNum(List<Integer> player){
        if(!isValidLength(player.size()))
            throw new IllegalArgumentException("사용자가 잘못된 값을 입력하였습니다.");

        if(isExistDuplicate(player))
            throw new IllegalArgumentException("사용자가 중복된 숫자를 입력하였습니다.");

        return true;
    }
}
