package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {

    public static List<Integer> createRandomBalls() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomBall = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomBall)) {
                randomNumbers.add(randomBall);
            }
        }
        return randomNumbers;
    }

}
