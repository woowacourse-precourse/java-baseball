package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumber;

    public void setRandomComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) { //중복 방지
                computer.add(randomNumber);
            }
        }

        this.computerNumber=computer;
    }

    public List<Integer> getComputerNumber(){
        return this.computerNumber;
    }
}
