package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = new ArrayList<Integer>();
        CreateRandomNum(computer);

        List<Integer> playerNum = new ArrayList<Integer>();
        inputNum(playerNum);

    }

    public static List<Integer> CreateRandomNum(List<Integer> computer){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> inputNum(List<Integer> playerNum){
        String playerNumString = Console.readLine();
        char [] playerNumCharArr = playerNumString.toCharArray();

        for(int c : playerNumCharArr){
            playerNum.add(c);
        }
        return playerNum;
    }
}
