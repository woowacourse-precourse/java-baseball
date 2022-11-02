package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameMachine {
    boolean gaming;
    List<Integer> Computer;
    List<Integer> gamer;

    GameMachine() {
        gaming = false;
        Computer = Collections.emptyList();
    }

    List<Integer> generateRandomNumber() {
        List<Integer> random = new ArrayList<>();
        while(random.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!random.contains(randomNumber)) {
                random.add(randomNumber);
            }
        }

        return random;
    }
}
