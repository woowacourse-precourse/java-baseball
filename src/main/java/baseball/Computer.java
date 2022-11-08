package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static baseball.Constant.*;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> randomNumber;

    public Computer(){
        randomNumber = new ArrayList<>();
    }
    public void makeRandomNumber() {
        while (randomNumber.size() < GAMEPLAY_SIZE) {
            int game_number = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!randomNumber.contains(game_number)) {
                randomNumber.add(game_number);
            }
        }
    }
}
