package baseball.data;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerInput {

    public List<Integer> GenerateComputerNumbers(){
        List<Integer> computer = new ArrayList<>(0);
        int randomNumber;
        while(computer.size() < BaseballData.GAME_SIZE){
            randomNumber = Randoms.pickNumberInRange(BaseballData.MINIMUM_NUMBER, BaseballData.MAXIMUM_NUMBER);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
