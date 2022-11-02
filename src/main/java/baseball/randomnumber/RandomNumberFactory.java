package baseball.randomnumber;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class RandomNumberFactory {

    public static RandomNumber newRandomNumber() {
        List<Integer> randomNumber = pickUniqueNumbersInRange(1, 9, 3);
        return new RandomNumber(randomNumber);
    }
}
