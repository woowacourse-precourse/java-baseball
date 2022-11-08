package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> numbersPickedByComputer;

    public void computerSelectThreeNumbers() {
        numbersPickedByComputer = new ArrayList<>();
        while (numbersPickedByComputer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbersPickedByComputer.contains(randomNumber)) {
                numbersPickedByComputer.add(randomNumber);
            }
        }
    }

}
