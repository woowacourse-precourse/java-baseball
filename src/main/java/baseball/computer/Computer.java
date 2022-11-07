package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Computer {
    private final List<Integer> baseballs = new ArrayList<>();

    public int[] getBaseballs() {
        return baseballs.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public void makeBalls(int BALL_COUNT) {
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
