package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PrepareGame {
    public List<Integer> setComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            computer = isEachDigit(computer);
        }
        return computer;
    }

    public List<Integer> isEachDigit(List<Integer> computer) {
        int randomNumber = Randoms.pickNumberInRange(1,9);
        if(!computer.contains(randomNumber)){
            computer.add(randomNumber);
        }
        return computer;
    }
}
