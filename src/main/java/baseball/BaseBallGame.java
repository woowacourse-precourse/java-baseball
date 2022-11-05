package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> user = new ArrayList<>();

    public List<Integer> randomNumbers() {
        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (computer.contains(randomNum) == false) {
                computer.add(randomNum);
            }
        }
        return computer;
    }

}