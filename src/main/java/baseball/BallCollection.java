package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BallCollection {
    public static final int BALL_COUNT = 3;

    private List<Integer> balls;

    public BallCollection(List<Integer> balls) {
        this.balls = balls;
    }

    public static BallCollection createComputerNumbers() {
        List<Integer> balls = new ArrayList<>();

        while (balls.size() < BALL_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber);
            }
        }

        return new BallCollection(balls);
    }

    public int size() {
        return this.balls.size();
    }
}
