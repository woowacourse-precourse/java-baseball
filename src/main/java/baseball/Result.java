package baseball;

import java.util.List;

public class Result {
    private static final int BALL_COUNT = 3;

    public static int[] getResult(List<Integer> balls, int[] userBalls) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < BALL_COUNT; i++) {
            if (userBalls[i] == balls.get(i)) {
                strike += 1;
            } else if (balls.contains(userBalls[i])) {
                ball += 1;
            }
        }
        return new int[]{ball, strike};
    }


}
