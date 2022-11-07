package baseball.data;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerInput {
    private final int MINIMUM = 1;
    private final int MAXIMUM = 9;
    public List<Integer> GenerateComputerNumbers(){
        List<Integer> computer = new ArrayList<>(0);
        int randomNumber;
        while(computer.size() < BaseballData.SIZE){
            randomNumber = Randoms.pickNumberInRange(MINIMUM, MAXIMUM);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
