package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomBalls {

    public static List<Integer> createRandomBalls() {
        List<Integer> randomBalls = new ArrayList<>();
        while (randomBalls.size() < 3) {
            int randomBall = Randoms.pickNumberInRange(1, 9);
            if (!randomBalls.contains(randomBall)) {
                randomBalls.add(randomBall);
            }
        }
        return randomBalls;
    }

}
