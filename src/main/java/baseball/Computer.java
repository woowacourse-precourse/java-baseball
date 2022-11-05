package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static constants.GameConstant.*;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public void makeComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public boolean isNotThreeStrike(String playerNumber) {
    }

    public void checkNumber(String playerNumber) {
    }
}
