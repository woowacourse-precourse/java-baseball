package baseball.domain;

import java.security.PublicKey;

public class GameReport {

    private int ball = 0;
    private int strike = 0;


    public void report(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            this.strike += 1;
        }
        if (ballStatus.isBall()) {
            this.ball += 1;
        }
    }

    public boolean isThreeStrike() {
        return this.strike == 3;
    }

    public void printCurrentGameCount() {
        System.out.println(ball + " 볼 " + strike + " 스트라이크");
    }
}
