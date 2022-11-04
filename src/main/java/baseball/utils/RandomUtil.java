package baseball.utils;

import baseball.domain.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.domain.ConstVariable.*;

public class RandomUtil {

    public static Balls makeRandomComputerBalls() {
        List<Integer> comBalls = new ArrayList<>();
        while (comBalls.size() < VALID_CNT) {
            addNotDuplicatedRandomNumber(comBalls, Randoms.pickNumberInRange(MIN, MAX));
        }
        return new Balls(comBalls);
    }

    private static void addNotDuplicatedRandomNumber(List<Integer> comBalls, int randomNumber) {
        if (!comBalls.contains(randomNumber)) {
            comBalls.add(randomNumber);
        }
    }
}
