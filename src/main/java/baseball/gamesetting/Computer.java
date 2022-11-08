package baseball.gamesetting;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public List<String> computerNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        List<String> computerNumberToString = new ArrayList<>();
        computerNumberToString.add(String.valueOf(computer.get(0)));
        computerNumberToString.add(String.valueOf(computer.get(1)));
        computerNumberToString.add(String.valueOf(computer.get(2)));
        return computerNumberToString;
    }
}
