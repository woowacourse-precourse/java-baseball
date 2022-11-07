package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerGenerate {
    public List<Integer> computer = new ArrayList<>();

    public ComputerGenerate(){
        while (computer.size() < Constant.NUM_SIZE) {
            AddComputerValue(computer);
        }
    }
    private static List<Integer> AddComputerValue(List<Integer> computer) {
        int randomNumber = Randoms.pickNumberInRange(1,9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
        return computer;
    }
}

