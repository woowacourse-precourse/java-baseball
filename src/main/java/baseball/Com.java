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
        List<Com> balls = new ArrayList<>();

        while (balls.size() < 3) {
            Ball ball = new Ball(Randoms.pickNumberInRange(1,9));

            if (!balls.contains(ball)) {
                balls.add(ball);
            }
        }
        return new Com(balls);
    }

    public static Com stringToBalls(String str) {
        char[] chars = str.toCharArray();
        List<Ball> balls = new ArrayList<>();

        for (char ch : chars) {
            balls.add(new Ball(ch));
        }
        return new Com(balls);
    }

    private void validate(List<Ball> balls) {
        Set<Ball> ballSet = new HashSet<>(balls);
        if (ballSet.size() != 3) {
            throw new IllegalArgumentException("공의 숫자가 중복 됩니다.");
        }

    }
}
