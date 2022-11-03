package baseball.util;

import static baseball.domain.Ball.MAX_BALL_NUMBER;
import static baseball.domain.Ball.MIN_BALL_NUMBER;
import static baseball.domain.Balls.BALLS_FORMAL_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {

    public static List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < BALLS_FORMAL_SIZE) {
            int randomBall = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
            if (!randomNumbers.contains(randomBall)) {
                randomNumbers.add(randomBall);
            }
        }
        return randomNumbers;
    }

}
