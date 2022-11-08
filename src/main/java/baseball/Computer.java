package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> RandomNumber = new ArrayList<>();

    public void createRandomNumber() {

        while (RandomNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!RandomNumber.contains(randomNumber)) {
                RandomNumber.add(randomNumber);
            }
        }
    }
}
