package baseball.domain;

import baseball.infrastructure.message.ConsoleOut;
import java.security.PublicKey;

public class GameReport {

    private int ball = 0;
    private int strike = 0;
    private int nothing = 0;


    public void report(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            this.strike += 1;
        }
        if (ballStatus.isBall()) {
            this.ball += 1;
        }
        if (ballStatus.isNothing()) {
            this.nothing += 1;
        }
    }

    public boolean isThreeStrike() {
        System.out.println("3스트라이크");
        return this.strike == 3;
    }

    public void printCurrentGameCount() {

        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public boolean isNothing() {
        return this.nothing == 3;
    }
    

    public void clear() {
        this.ball = 0;
        this.strike = 0;
        this.nothing = 0;
    }
}
