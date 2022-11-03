package baseball.util;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.Constant.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public abstract class Util {
    public static List<Integer> pickRandomNumberList() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = pickNumberInRange(MIN_NUMBER_VALUE, MAX_NUMBER_VALUE);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
