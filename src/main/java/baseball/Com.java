package baseball;


import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Com {

    public static final int BALLS_COUNT = 3;

    private final List<Ball> balls;

    public Com(List<Ball> balls) {
        validate(balls);
        this.balls = balls;
    }

    public static Com makeRandomBalls() {
        List<Ball> balls = new ArrayList<>();

        while (balls.size() < 3) {
            Ball ball = new Ball(pickNumberInRange(1, 9));

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
        if (ballSet.size() != BALLS_COUNT) {
            throw new IllegalArgumentException("공의 숫자가 중복 됩니다.");
        }

    }

    public Ball get(int index) {
        return balls.get(index);
    }

    public boolean contains(Ball ball) {
        return this.balls.contains(ball);
    }
}
