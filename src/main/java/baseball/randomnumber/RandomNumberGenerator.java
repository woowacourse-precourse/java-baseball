package baseball.randomnumber;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class RandomNumberGenerator {

    public static List<Integer> getRandomNumber() {
        return pickUniqueNumbersInRange(1, 9, 3);
    }
}
