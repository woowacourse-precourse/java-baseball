package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class computerNumber {
    public static List<Integer> computer = new ArrayList<>();

    public void setComputer(){
        this.computer.clear();
        while (this.computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.computer.contains(randomNumber)) {
                this.computer.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputer(){
        return computer;
    }



}
