package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    void ramdomComputer (List<Integer> computer){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
