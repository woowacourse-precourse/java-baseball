package baseball;
import baseball.CheckException;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameSet {

    public static List<Integer> setComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3) {
            int computerNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(computerNumber)) {
                computer.add(computerNumber);
            }
        }
        return computer;
    }

    public static String attachComputerNumber(){
        String computerNumber = "";
        List<Integer> computer = setComputerNumber();
        for(Integer number : computer){
            computerNumber += Integer.toString(number);
        }
        return computerNumber;
    }
    
    public static String inputPlayerNumber(){
        String playerNumber = readLine();
        CheckException.check(playerNumber);
        return playerNumber;
    }
}
