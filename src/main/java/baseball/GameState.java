package baseball;

import static constant.Constant.*;

public class GameState {
    private int strike;
    private int ball;

    public GameState() {
        this.strike = INITIAL_NUMBER;
        this.ball = INITIAL_NUMBER;
    }

    public void addStrike() {
        ++strike;
    }

    public void addBall() {
        ++ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void printGameState() {
        if (this.strike == ZERO && this.ball == ZERO) {
            System.out.println(NOTHING);
            return;
        }
        if (this.ball == ZERO) {
            System.out.println(this.strike + STRIKE);
            return;
        }
        if (this.strike == ZERO) {
            System.out.println(this.ball + BALL);
            return;
        }
        System.out.println(this.ball + BALL + " " + this.strike + STRIKE);
    }
}
