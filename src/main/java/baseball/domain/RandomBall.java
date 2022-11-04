package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomBall {
    public static List<Integer> computerBalls = new ArrayList<>();
    static int baseBallSize = 3;

    public static void makeRandomBalls() {
        while (computerBalls.size() < baseBallSize) {
            addRandomNumber(computerBalls);
        }
    }

    private static void addRandomNumber(List<Integer> computerBalls) {
        int randomBall = Randoms.pickNumberInRange(1, 9);
        if (!computerBalls.contains(randomBall)) {
            computerBalls.add(randomBall);
        }
    }

    public static void makeNewRandomBalls() {
        removeTwoNumber();
        while (computerBalls.size() < baseBallSize) {
            addRandomNumber(computerBalls);
        }
    }

    private static void removeTwoNumber() {
        int firstIndex = 0;
        for (int number = 0; number < 2; number++) {
            computerBalls.remove(firstIndex);
        }
    }
}
