package baseball;
import baseball.CheckException;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameSet {

    public static void setComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3) {
            int computerNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(computerNumber)) {
                computer.add(computerNumber);
            }
        }
    }

}
