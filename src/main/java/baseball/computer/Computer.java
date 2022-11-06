package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.AppConfig.BALL_COUNT;

public class Computer {
    private final List<Integer> baseballs = new ArrayList<>(BALL_COUNT);

    public int[] getBaseballs() {
        return baseballs.stream()
                .mapToInt(Integer::intValue)
                .toArray();
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
