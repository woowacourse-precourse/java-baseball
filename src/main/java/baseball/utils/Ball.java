package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ball {
    private static final int COMPUTER_MAX_SIZE = 3;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;

    private Ball() {
    }

    private static class BallHolder {
        private static final Ball INSTANCE = new Ball();
    }

    public static Ball getInstance() {
        return BallHolder.INSTANCE;
    }

    public String createRandomBall() {
        return String.valueOf(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
    }

    public List<String> makeComputerBalls() {
        Set<String> balls = new HashSet<>();
        while (balls.size() < COMPUTER_MAX_SIZE) {
            balls.add(createRandomBall());
        }
        return new ArrayList<>(balls);
    }
}
