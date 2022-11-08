package baseball;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Com {

    private final List<Ball> balls;

    public Com(List<Ball> balls) {

        this.balls = balls;
    }

    public static Com makeRandomBalls() {
        List<Com> com_balls = new ArrayList<>();

        while (com_balls.size() < 3) {
            Ball ball = new Ball(Randoms.pickNumberInRange(1,9));

            if (!com_balls.contains(ball)) {
                com_balls.add(ball);
            }
        }
        return new Com(com_balls);
    }
}
