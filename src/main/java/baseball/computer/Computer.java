package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int BALL_COUNT = 3;
    private final List<Integer> baseballs = new ArrayList<>(BALL_COUNT);

    public List<Integer> getBaseballs() {
        return baseballs;
    }

    public void makeBalls() {
        while (baseballs.size() < BALL_COUNT) {
            int ball = Randoms.pickNumberInRange(1, 9);
            insertBall(ball);
        }
    }

    public void insertBall(int ball) {
        if (!isDuplicate(ball)) {
            baseballs.add(ball);
        }
    }

    public Boolean isDuplicate(int ball) {
        return baseballs.contains(ball);
    }
}
