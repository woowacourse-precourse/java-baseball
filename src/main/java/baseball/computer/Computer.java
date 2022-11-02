package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int BALL_COUNT = 3;
    private final List<Integer> baseballGameNum = new ArrayList<>(BALL_COUNT);

    public List<Integer> getBaseballGameNum() {
        return baseballGameNum;
    }

    public void makeBalls() {
        while (baseballGameNum.size() < BALL_COUNT) {
            int ball = Randoms.pickNumberInRange(1, 9);
            if (!baseballGameNum.contains(ball)) {
                baseballGameNum.add(ball);
            }
        }
    }
}
