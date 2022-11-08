package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    static final int BallsLength = 3;

    public static List<Integer> makeBalls() {
        List<Integer> computerBallsList = new ArrayList<>();

        while (computerBallsList.size() < BallsLength) {
            int randomBall = Randoms.pickNumberInRange(1, 9);

            if (!computerBallsList.contains(randomBall)) {
                computerBallsList.add(randomBall);
            }
        }
        return computerBallsList;
    }
}
