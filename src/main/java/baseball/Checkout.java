package baseball;

import static baseball.Com.*;

public class Checkout {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    private final Integer strike;
    private final Integer ball;

    public Checkout(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Checkout checkBalls(Com gameBalls, Com userBalls) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            Ball thisBall = gameBalls.get(i);

            if (thisBall.equals(userBalls.get(i))) {
                strike++;
                continue;
            }
            if (userBalls.contains(thisBall)) {
                ball++;
            }
        }

        return new Checkout(strike, ball);
    }

}
