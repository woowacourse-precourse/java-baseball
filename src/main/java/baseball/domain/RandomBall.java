package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomBall {
    public List<Integer> makeRandomBalls() {
        List<Integer> computerBalls = new ArrayList<>();
        while (computerBalls.size() < 3) {
            addRandomNumber(computerBalls);
        }
        return computerBalls;
    }

    private static void addRandomNumber(List<Integer> computerBalls) {
        int randomBall = Randoms.pickNumberInRange(1, 9);
        if (!computerBalls.contains(randomBall)) {
            computerBalls.add(randomBall);
        }
    }
}
