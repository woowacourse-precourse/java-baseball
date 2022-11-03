package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Integer> computer;

    public Game() {
        this.computer = initComputer();
    }

    private List<Integer> initComputer() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber;

        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
