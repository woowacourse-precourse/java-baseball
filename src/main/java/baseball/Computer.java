package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    public static final int NUM_LIMIT_LENGTH = 3;

    public static List<Integer> createRandomNumbers() {
        Set<Integer> randomNumber = new LinkedHashSet<>(NUM_LIMIT_LENGTH);
        while (randomNumber.size() != NUM_LIMIT_LENGTH) {
            int number = pickNumberInRange(1, 9);
            randomNumber.add(number);
        }
        List<Integer> computerNum = new ArrayList<>(randomNumber);
        return computerNum;
    }
}
