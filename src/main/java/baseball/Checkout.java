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

        for (int i = 0; i < BALLS_COUNT; i++) {
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

    public String getResultMessage() {
        if (isNothing()) {
            return NOTHING;
        }
        if (isStrike()) {
            return strike + STRIKE;
        }
        if (isBall()) {
            return ball + BALL;
        }
        return ball + BALL + " " + strike + STRIKE;
    }

    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    private boolean isStrike() {
        return 0 < strike && ball == 0;
    }

    private boolean isBall() {
        return strike == 0 && 0 < ball;
    }

    private void printEndMessage() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", BALLS_COUNT);
    }

    public boolean isAllStrikes() {
        if (strike == BALLS_COUNT) {
            printEndMessage();
            return true;
        }
        return false;
    }


}
