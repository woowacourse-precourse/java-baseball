package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import static constants.GameConstant.*;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public void makeComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public boolean isNotThreeStrike(String playerNumber) {
    }

    public void checkNumber(String playerNumber) {
    }
}
