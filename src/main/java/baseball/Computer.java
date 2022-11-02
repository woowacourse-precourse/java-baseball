package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {
    static final int NUM_LIMIT_LENGTH = 3;

    void createRandomNumbers() {
        Set<Integer> randomNumber = new LinkedHashSet<>(NUM_LIMIT_LENGTH);
        while (randomNumber.size()!=NUM_LIMIT_LENGTH) {
            int number = pickNumberInRange(1, 9);
            randomNumber.add(number);
        }
    }


}
