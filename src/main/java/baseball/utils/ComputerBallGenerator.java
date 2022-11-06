package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ComputerBallGenerator {

    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 9;

    public static List<Integer> generateComputerBalls() {
        LinkedHashSet<Integer> computerBalls = new LinkedHashSet<>();
        while (computerBalls.size() != BallValidator.MAX_BALL_SIZE) {
            computerBalls.add(Randoms.pickNumberInRange(MINIMUM_BALL_NUMBER, MAXIMUM_BALL_NUMBER));
        }

        return new ArrayList<>(computerBalls);
    }
}
