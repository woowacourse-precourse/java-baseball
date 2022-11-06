package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.ConstantValue.BASEBALL_NUMBER_SIZE;

public class GameManager {
    public GameManager(){
    }

    public List<Integer> createComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < BASEBALL_NUMBER_SIZE){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
