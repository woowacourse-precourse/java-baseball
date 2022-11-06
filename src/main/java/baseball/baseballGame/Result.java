package baseball.baseballGame;

import java.util.Arrays;

import static baseball.AppConfig.BALL_COUNT;

public class Result {
    public static int[] getResult(int[] balls, int[] userBalls) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < BALL_COUNT; i++) {
            if (equal(balls[i], userBalls[i])) {
                strike += 1;
            } else if (contain(balls, userBalls[i])) {
                ball += 1;
            }
        }
        return new int[]{ball, strike};
    }

    public static Boolean equal(int ball, int userBall) {
        return ball == userBall;
    }

    public static Boolean contain(int[] balls, int userBall) {
        return Arrays.stream(balls)
                .anyMatch(num -> num == userBall);
    }
}
